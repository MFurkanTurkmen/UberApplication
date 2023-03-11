package com.furkan.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    private String exchangeDirectAuth = "exchange-direct-auth";
    private String bindingKeyAuth = "binding-key-auth";
    private String queueCreateDriver = "queue-create-driver";
    private String queueCreatePassenger = "queue-create-passenger";


    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(exchangeDirectAuth);
    }

    @Bean
    Queue queueCreateDriver() {
        return new Queue(queueCreateDriver);
    }

    @Bean
    Binding bindingCreateDriver(final Queue queue, final DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(bindingKeyAuth);
    }

    @Bean
    Binding bindingCreatePassenger(final Queue queue, final DirectExchange directExchange) {
        return BindingBuilder.bind(queue).to(directExchange).with(bindingKeyAuth);
    }
}