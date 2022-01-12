package com.yash.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages = "com.yash.*")
@ImportResource("classpath:applicationContext.xml")
@PropertySource("classpath:db.properties")
public class QuizSpringBootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizSpringBootAppApplication.class, args);
	}

}
