/**
 * @Author: chufeng Chen
 * @Description:
 * @Date:Create：in 2021/3/23 22:43
 */
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Test_Provider {
    @Test
    //生产消息
    public void testSendMessage(){
        //创建连接mq的连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //设置连接rabbitmq的主机
        connectionFactory.setHost("47.119.120.170");
        //设置端口号
        connectionFactory.setPort(5672);
        //设置连接哪个虚拟主机
        connectionFactory.setVirtualHost("Kevin");
        //设置访问虚拟主机的用户名密码
        connectionFactory.setUsername("Kevin");
        connectionFactory.setPassword("123");
        //获取连接对象
        try {
            Connection connection = connectionFactory.newConnection();
            //获取连接的通道
            Channel channel = connection.createChannel();
            //通道绑定对应的消息队列
            // 参数1：队列名称，如果队列不存在自动创建
            //参数2：用来定义队列的特性是否要持久化，true为持久化 false为不持久化
            //参数3:exclusive 是否独占队列 true为独占队列 false为不独占
            //参数4：auto delete 是否在消费完成后自动删除队列 true为自动删除，false为不自动删除
            //参数5：额外附加参数
            channel.queueDeclare("Myqueue",false,false,false,null);
            //发布消息
            //参数1：交换机名称 参数2：队列名称 参数3：传递消息额外设置 参数4：消息的具体内容
            channel.basicPublish("","Myqueue",null,"hello rabbitmq".getBytes());
            channel.close();
            connection.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

    }
}
