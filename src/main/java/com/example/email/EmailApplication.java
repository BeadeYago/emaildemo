package com.example.email;

import com.example.email.entity.Person;
import com.example.email.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class EmailApplication {

	@Autowired
	private EmailSenderService emailService;

	public static void main(String[] args) {
		SpringApplication.run(EmailApplication.class, args);
	}

}
