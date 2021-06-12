package com.rabbitmq.service.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @Author: chufeng Chen
 * @Description:
 * @Date:Create：in 2021/6/12 15:53
 */
@Service
@RabbitListener(queues = {"email.fanout.queue"})
public class FanoutEmailConsumer {
    @RabbitHandler //把方法标记为一个消息的落脚点
    public void receiveMessage(String message){
        System.out.println("email fanout---接收到了订单信息:->"+message);
    }
}
