package rabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import util.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: chufeng Chen
 * @Description:
 * @Date:Create：in 2021/6/3 23:58
 */
public class Producer {
    public static void main(String[] args) {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel=null;
        //通过连接获取通道channel
        try {
            channel = connection.createChannel();
            String queueName="QUEUE1";

            /**
             * @params1 队列的名称
             * @params2 是否要持久化，所谓持久化消息是否存盘，当true时，重启MQ服务器，队列还会在，当false时，重启服务器队列会消失，数据也会丢失
             * @params3 排他性，是否是独占独立
             * @params4 是否自动删除，随着最后一个消费者消息完毕消息以后是否把队列自动删除
             * @params5 携带附属参数
             */
            channel.queueDeclare(queueName,false,false,false,null);
            String message="kuangshen";
            channel.basicPublish("",queueName,null,message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");

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
