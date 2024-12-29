package com.pjsoft.fms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@ComponentScan(basePackages = {"com.pjsoft.fms", "com.pjsoft.test.fms"})
@EnableRetry
public class FmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FmsApplication.class, args);
	}

}
