package com.agencia.fantur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;


@SpringBootApplication
@EnableRetry
public class FanturApplication/* implements CommandLineRunner*/ {


	public static void main(String[] args) {

		SpringApplication.run(FanturApplication.class, args);


		System.out.println("Ejecutando aplicacion en Spring Boot");
	}

}
