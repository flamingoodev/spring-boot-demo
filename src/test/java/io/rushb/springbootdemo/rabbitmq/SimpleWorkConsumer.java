package io.rushb.springbootdemo.rabbitmq;

import com.rabbitmq.client.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 消费者
 *
 * @author <a href="mailto:flamingodev@outlook.com">FLAMINGO</a>
 * @since 2020/10/3 18:01
 */
public class SimpleWorkConsumer {
    @Test
    public void testReceiveMessage() throws IOException, TimeoutException {
        // 创建连接MQ的连接工厂对象
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // 设置连接MQ的主机
        connectionFactory.setHost("127.0.0.1");
        // 设置端口
        connectionFactory.setPort(5672);
        // 设置虚拟主机
        connectionFactory.setVirtualHost("/");
        // 设置用户
        connectionFactory.setUsername("guest");
        // 设置密码
        connectionFactory.setPassword("guest");
        // 获取连接
        Connection connection = connectionFactory.newConnection();
        // 通过连接获取通道对象
        Channel channel = connection.createChannel();
        // 绑定通道和消息队列
        // 以下参数要和生产者的参数完全一致
        channel.queueDeclare("hello", false, false, false, null);
        // 消费消息
        // 参数1：队列名称
        // 参数2：开启消息的自动确认机制
        // 参数3：消费消息时的回调接口
        channel.basicConsume("hello", true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("body = " + new String(body));
            }
        });
        System.out.println("Listening messages...");
        System.out.println(System.in.read());
//        channel.close();
//        connection.close();
    }
}
