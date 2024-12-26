package com.store.client.clientapi;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableRabbit
@SpringBootApplication
public class ClientApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApiApplication.class, args);
	}

}
