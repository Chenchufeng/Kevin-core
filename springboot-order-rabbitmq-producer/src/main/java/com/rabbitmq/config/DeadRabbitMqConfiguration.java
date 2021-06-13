package com.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * @Author: chufeng Chen
 * @Description:
 * @Date:Create：in 2021/6/12 15:15
 */
@Configuration
public class DeadRabbitMqConfiguration {
    //1.声明注册direct模式的交换机
    @Bean
    DirectExchange deaddirectExchange(){
        return new DirectExchange("dead_direct_exchange",true,false);
    }

    //2.队列的过期时间
    @Bean
    public Queue deadQueue(){
        return new Queue("dead.direct.queue",true);
    }


    @Bean
    Binding deadBinding() {

        return BindingBuilder.bind(deadQueue()).to(deaddirectExchange()).with("dead");
    }
}
