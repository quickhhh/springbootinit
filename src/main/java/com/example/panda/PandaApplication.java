package com.example.panda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PandaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PandaApplication.class, args);
	}
}
