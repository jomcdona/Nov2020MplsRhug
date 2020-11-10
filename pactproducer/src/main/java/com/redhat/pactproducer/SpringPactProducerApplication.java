package com.redhat.pactproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringPactProducerApplication {

	public static void main(String[] args) {

		SpringApplication.run(
				new Object[] { SpringPactProducerApplication.class }, args);
	}
}