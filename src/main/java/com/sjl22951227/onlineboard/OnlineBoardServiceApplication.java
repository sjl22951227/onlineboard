package com.sjl22951227.onlineboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class OnlineBoardServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineBoardServiceApplication.class, args);
	}

	//Cors
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedMethods("*")
						.allowedOrigins("*");//#CHANGE //NOT RECOMMENDED FOR PRODUCTION
			}
		};
	}
}
