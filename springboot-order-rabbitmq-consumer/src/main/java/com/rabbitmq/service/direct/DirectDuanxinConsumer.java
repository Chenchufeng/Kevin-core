package com.rabbitmq.service.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @Author: chufeng Chen
 * @Description:
 * @Date:Create：in 2021/6/12 15:53
 */
//使用 @RabbitListener 注解标记方法，当监听到队列中有消息时则会进行接收并处理
//@RabbitListener 标注在类上面表示当有收到消息的时候，就交给 @RabbitHandler 的方法处理，具体使用哪个方法处理，根据 MessageConverter 转换后的参数类型
@Service
@RabbitListener(queues = {"duanxin.direct.queue"})
public class DirectDuanxinConsumer {

    @RabbitHandler //把方法标记为一个消息的落脚点
    public void receiveMessage(String message){
        System.out.println("duanxin direct---接收到了订单信息:->"+message);
    }
}
