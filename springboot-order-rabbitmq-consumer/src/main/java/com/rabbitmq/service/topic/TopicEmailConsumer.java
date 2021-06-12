package com.rabbitmq.service.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @Author: chufeng Chen
 * @Description:
 * @Date:Create：in 2021/6/12 15:53
 */
@Service
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "email.topic.queue",durable = "true",autoDelete = "false"),
        exchange=@Exchange(value = "topic_order_exchange",type = ExchangeTypes.TOPIC),
        key = "*.email.#"
))
public class TopicEmailConsumer {
    @RabbitHandler //把方法标记为一个消息的落脚点
    public void receiveMessage(String message){
        System.out.println("email topic---接收到了订单信息:->"+message);
    }
}
