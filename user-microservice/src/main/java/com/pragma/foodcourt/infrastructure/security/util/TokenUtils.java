package com.pragma.foodcourt.infrastructure.security.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class TokenUtils {

    private static final String ACCESS_TOKEN_SECRET = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9";
    private static final Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000l;

    public static String createToken(UserDetails userDetails) {
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1_000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);
        String email = userDetails.getUsername();
        String role = userDetails
                .getAuthorities()
                .stream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Not found role for this user."))
                .getAuthority();

        Claims claims = Jwts.claims().setSubject(email);
        claims.put("role", role);

        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(expirationDate)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();
//        Map<String, Object> extra = new HashMap<>();
//        extra.put("roles", role);

//        return Jwts
//                .builder()
//                .setSubject(email)
//                .setExpiration(expirationDate)
//                .addClaims(extra)
//                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
//                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthenticationToken(String token) {
        try {
            Claims claims = Jwts
                    .parserBuilder()
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String email = claims.getSubject();
            String role = (String) claims.get("role");
            Collection<? extends GrantedAuthority> authorities =
                    Collections.singletonList(new SimpleGrantedAuthority(role));
            return new UsernamePasswordAuthenticationToken(
                    email,
                    null,
                    authorities
            );
        }
        catch (JwtException e) {
            return null;
        }
    }

}
