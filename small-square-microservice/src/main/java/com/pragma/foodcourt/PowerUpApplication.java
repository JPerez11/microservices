package com.pragma.foodcourt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PowerUpApplication {

	public static void main(String[] args) {
		SpringApplication.run(PowerUpApplication.class, args);
	}

}
