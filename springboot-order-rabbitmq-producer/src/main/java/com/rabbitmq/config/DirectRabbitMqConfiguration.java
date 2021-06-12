package com.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: chufeng Chen
 * @Description:
 * @Date:Create：in 2021/6/12 15:15
 */
@Configuration
public class DirectRabbitMqConfiguration {
    //1.声明注册direct模式的交换机
    @Bean //@Bean 用在方法上，告诉Spring容器，你可以从下面这个方法中拿到一个Bean
    DirectExchange directExchange(){
        return new DirectExchange("direct_order_exchange",true,false);
    }

    //2.声明队列 sms.direct.queue email.direct.queue duanxin.direct.queue
    @Bean
    public Queue directSmsQueue(){
        return new Queue("sms.direct.queue",true);
    }

    @Bean
    public Queue directDuanxinQueue(){
        return new Queue("duanxin.direct.queue",true);
    }

    @Bean
    public Queue directEmailQueue(){
        return new Queue("email.direct.queue",true);
    }
    //3.完成绑定关系(队列和交换机完成绑定关系)
    @Bean
    Binding directSmsBinding() {
        return BindingBuilder.bind(directSmsQueue()).to(directExchange()).with("sms");
    }

    @Bean
    Binding directDuanxinBinding() {
        return BindingBuilder.bind(directDuanxinQueue()).to(directExchange()).with("duanxin");
    }

    @Bean
    Binding directEmailBinding() {
        return BindingBuilder.bind(directEmailQueue()).to(directExchange()).with("email");
    }
}
