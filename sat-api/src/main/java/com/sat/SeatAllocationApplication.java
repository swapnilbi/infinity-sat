package com.sat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@ComponentScan(basePackages = "com.sat")
@CrossOrigin(origins = "http://localhost:4200")
public class SeatAllocationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeatAllocationApplication.class, args);
	}
}
