package com.ste.sdhapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SdhapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SdhapplicationApplication.class, args);
	}

}
