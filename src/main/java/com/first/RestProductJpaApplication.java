package com.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * @SpringBootApplication this annotation is used to mark the main class of a spring boot application.
 * It encapsulates @SpringBootConfiguration,@EnableAutoConfiguration,@ComponentScan
 */
@SpringBootApplication

public class RestProductJpaApplication 
{
    
	public static void main(String[] args) 
	{
		
		SpringApplication.run(RestProductJpaApplication.class, args);
	}

}
