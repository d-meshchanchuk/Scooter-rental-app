package com.senla.scooterrentalapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ScooterRentalAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScooterRentalAppApplication.class, args);
	}

}
