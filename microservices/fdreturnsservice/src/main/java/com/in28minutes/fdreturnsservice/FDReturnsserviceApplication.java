package com.in28minutes.fdreturnsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FDReturnsserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FDReturnsserviceApplication.class, args);
	}

}
