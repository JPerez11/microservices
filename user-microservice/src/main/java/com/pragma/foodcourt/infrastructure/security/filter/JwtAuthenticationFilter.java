package com.pragma.foodcourt.infrastructure.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pragma.foodcourt.infrastructure.output.jpa.entity.UserEntity;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IUserRepository;
import com.pragma.foodcourt.infrastructure.security.dto.AuthCredentials;
import com.pragma.foodcourt.infrastructure.security.service.UserDetailsImpl;
import com.pragma.foodcourt.infrastructure.security.util.TokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final IUserRepository userRepository;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        AuthCredentials authCredentials;
        try {
            authCredentials = new ObjectMapper().readValue(request.getReader(), AuthCredentials.class);

        } catch (IOException e) {
            return null;
        }

        UserEntity user = userRepository.findByEmail(authCredentials.getEmail());
        UserDetailsImpl userDetails = new UserDetailsImpl(user);


        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                authCredentials.getEmail(),
                authCredentials.getPassword(),
                userDetails.getAuthorities()
        );

        return getAuthenticationManager().authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        UserDetailsImpl userDetails = (UserDetailsImpl) authResult.getPrincipal();
        String token = TokenUtils.createToken(userDetails);

        response.addHeader("Authorization", "Bearer " + token);
        response.getWriter().flush();

        super.successfulAuthentication(request, response, chain, authResult);

    }

}
