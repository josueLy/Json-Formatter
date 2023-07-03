package com.example.json_formater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.*")
public class JsonFormaterApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonFormaterApplication.class, args);
	}

}
