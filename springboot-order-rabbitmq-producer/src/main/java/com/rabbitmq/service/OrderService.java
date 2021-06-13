package com.rabbitmq.service;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Author: chufeng Chen
 * @Description:
 * @Date:Create：in 2021/6/12 14:41
 */
@Service
public class OrderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * @Author Chufeng
     * @Description 模拟用户下单
     * @Date 15:08 2021/6/12
     * @Param
     * @return
     */
    public void makeOrder(String userid,String productid,int num){
        //1.根据商品id查询库存是否充足
        //2.保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生成成功: "+orderId);
        //3.通过MQ来完成消息的分发
        String exchangeName="fanout_order_exchange";
        String routingKey="";
        rabbitTemplate.convertAndSend(exchangeName,routingKey,orderId);
    }

    /**
     * @Author Chufeng
     * @Description  使用direct模式模拟用户下单
     * @Date 16:25 2021/6/12
     * @Param
     * @return
     */
    public void makeOrderDirect(String userid,String productid,int num){
        //1.根据商品id查询库存是否充足
        //2.保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生成成功: "+orderId);
        //3.通过MQ来完成消息的分发
        String exchangeName="direct_order_exchange";
        rabbitTemplate.convertAndSend(exchangeName,"email",orderId);
        rabbitTemplate.convertAndSend(exchangeName,"duanxin",orderId);
//        rabbitTemplate.convertAndSend(exchangeName,"sms",orderId);
    }

    public void makeOrderTopic(String userid,String productid,int num){
        //1.根据商品id查询库存是否充足
        //2.保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生成成功: "+orderId);
        //3.通过MQ来完成消息的分发
        String exchangeName="topic_order_exchange";
        String routingKey="com.duanxin";  //duanxin和sms能收到,email收不到
        //#表示0,1,多个   *表示一定要有一个
        //	#.duanxin.#  duanxin
        //  *.email.#    email
        //  com.#   sms
        rabbitTemplate.convertAndSend(exchangeName,routingKey,orderId);
    }


    public void makeOrderTtl(String userid,String productid,int num){
        //1.根据商品id查询库存是否充足
        //2.保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生成成功: "+orderId);
        //3.通过MQ来完成消息的分发
        String exchangeName="ttl_direct_exchange";
        String routingKey="ttl";  //duanxin和sms能收到,email收不到
        rabbitTemplate.convertAndSend(exchangeName,routingKey,orderId);
    }


    public void makeOrderTtlMessasge(String userid,String productid,int num){
        //1.根据商品id查询库存是否充足
        //2.保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生成成功: "+orderId);
        //3.通过MQ来完成消息的分发
        String exchangeName="ttl_direct_exchange";
        String routingKey="ttlmessage";  //duanxin和sms能收到,email收不到
        //给消息设置过期时间
        MessagePostProcessor messagePostProcessor = new MessagePostProcessor() { //匿名内部类写法
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                //这里就是字符串
                message.getMessageProperties().setExpiration("5000");
                message.getMessageProperties().setContentEncoding("UTF-8");
                return message;
            }
        };
        rabbitTemplate.convertAndSend(exchangeName,routingKey,orderId,messagePostProcessor);
    }
}
