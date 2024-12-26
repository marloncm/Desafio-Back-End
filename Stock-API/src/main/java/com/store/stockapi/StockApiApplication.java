package com.store.stockapi;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class StockApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockApiApplication.class, args);
	}

}
