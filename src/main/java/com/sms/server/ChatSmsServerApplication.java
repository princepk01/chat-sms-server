package com.sms.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatSmsServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatSmsServerApplication.class, args);
		System.out.println("======main medthod completed=====");   
	}

}
