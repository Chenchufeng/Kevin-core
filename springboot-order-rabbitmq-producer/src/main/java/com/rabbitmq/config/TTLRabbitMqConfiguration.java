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
public class TTLRabbitMqConfiguration {
    //1.声明注册direct模式的交换机
    @Bean //@Bean 用在方法上，告诉Spring容器，你可以从下面这个方法中拿到一个Bean
    DirectExchange ttldirectExchange(){
        return new DirectExchange("ttl_direct_exchange",true,false);
    }

    //2.队列的过期时间
    @Bean
    public Queue directttlQueue(){
        //设置过期时间
        HashMap<String,Object> args=new HashMap<>();
        args.put("x-message-ttl",5000);//设置过期时间的毫秒数，一定是int类型
        args.put("x-dead-letter-exchange","dead_direct_exchange");//将此队列跟死信队列的交换机联系在一起
        args.put("x-dead-letter-routing-key","dead");//因为交换机是direct模式，还要设置key,fanout模式就不需要配置
        return new Queue("ttl.direct.queue",true,false,false,args);
    }

    //消息在队列中的过期时间
    @Bean
    public Queue directttlMessageQueue(){
        return new Queue("ttl.message.direct.queue",true);
    }

    @Bean
    Binding ttlBinding() {
        return BindingBuilder.bind(directttlQueue()).to(ttldirectExchange()).with("ttl");
    }

    @Bean
    Binding ttlMessageBinding() {

        return BindingBuilder.bind(directttlMessageQueue()).to(ttldirectExchange()).with("ttlmessage");
    }
}
