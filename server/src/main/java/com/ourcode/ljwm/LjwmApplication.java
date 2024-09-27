package com.ourcode.ljwm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class LjwmApplication {

	public static void main(String[] args) {
		Dotenv env = Dotenv.load();
		System.setProperty("DATABASE_URL", env.get("DATABASE_URL"));
		System.setProperty("DATABASE_USERNAME",env.get("DATABASE_USERNAME"));
		System.setProperty("DATABASE_PASSWORD",env.get("DATABASE_PASSWORD"));
		System.setProperty("UPLOAD_DIR",env.get("UPLOAD_DIR"));
		SpringApplication.run(LjwmApplication.class, args);
	}

}
