package rabbitmq.simple;

import com.rabbitmq.client.*;
import util.ConnectionUtil;

import java.io.IOException;

/**
 * @Author: chufeng Chen
 * @Description:
 * @Date:Create：in 2021/6/4 0:00
 */
public class Consumer {
    public static void main(String[] args) {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel=null;
        //通过连接获取通道channel
        try {
            channel = connection.createChannel();
            String queueName="QUEUE1";
            channel.basicConsume(queueName, true, new DeliverCallback() {
                @Override
                public void handle(String s, Delivery message) throws IOException {
                    System.out.println("收到消息是: " + new String(message.getBody(), "UTF-8"));
                }
            }, new CancelCallback() {
                @Override
                public void handle(String s) throws IOException {
                    System.out.println("消息接收失败了");
                }
            });
            System.out.println("开始接收消息");
            System.in.read();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(channel!=null && channel.isOpen()){
                try {
                    channel.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(connection!=null && connection.isOpen()){
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
