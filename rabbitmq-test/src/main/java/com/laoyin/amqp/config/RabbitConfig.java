package com.laoyin.amqp.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author : yinquan.gong
 * @version V1.0
 * @Description: TODO
 * @date Date : 2020年09月15日 6:12 下午
 */
@Component
public class RabbitConfig {

    @Bean
    public Queue userQueue() {
        return new Queue("user_queue");
    }

    @Bean
    public DirectExchange userExchange() {
        return new DirectExchange("user_exchange");
    }

    @Bean
    public Binding binding(Queue userQueue, DirectExchange userExchange) {
        return BindingBuilder.bind(userQueue).to(userExchange).with("user");
    }
}
