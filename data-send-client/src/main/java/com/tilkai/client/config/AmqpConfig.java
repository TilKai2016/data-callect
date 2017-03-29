package com.tilkai.client.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tilkai
 */
@Configuration
public class AmqpConfig {

    public final static int delay = 6000;

    @Bean
    MessageConverter jackson2JsonMessageConverter() {return new Jackson2JsonMessageConverter();}

    @Bean
    public Queue fooQueue() {return new Queue("hpvm.data");}

}
