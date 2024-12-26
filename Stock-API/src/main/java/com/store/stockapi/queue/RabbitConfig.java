package com.store.stockapi.queue;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue purchaseQueue() {
        return new Queue("purchase", true, false, false); // true para ser durável
    }
}
