package com.projarq.trabalho02_microservicos.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue subscriptionUpdateQueue() {
        return new Queue("subscription-update-queue", false);
    }
}
