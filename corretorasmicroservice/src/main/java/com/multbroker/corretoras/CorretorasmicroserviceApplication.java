package com.multbroker.corretoras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableEurekaClient
@EnableWebMvc
@SpringBootApplication
@EntityScan("com.multbroker.models")
public class CorretorasmicroserviceApplication  {

	public static void main(String[] args) {
		SpringApplication.run(CorretorasmicroserviceApplication.class, args);
	}

}
