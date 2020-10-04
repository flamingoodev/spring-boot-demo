package io.rushb.springbootdemo.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * RabbitMQ消息生产者
 *
 * @author <a href="mailto:flamingodev@outlook.com">FLAMINGO</a>
 * @since 2020/10/3 17:03
 */
public class SimpleWorkProvider {
    /**
     * 第一种模型 点对点直连
     * 只能被一个消费者消费
     * 直接生产者到队列，不经过交换机
     *
     * @throws IOException      io异常
     * @throws TimeoutException 超时异常
     */
    @Test
    public void testSendMessage() throws IOException, TimeoutException {
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
        // 以下参数要和消费者的参数完全一致
        // 参数1：队列名称（如果队列不存在则自动创建）
        // 参数2：用来定义参数是否需要持久化
        // 参数3：exclusive 是否独占队列，表示当前队列是否仅当前连接可用
        // 参数4：autoDelete 是否在消费完成后自动删除队列
        // 参数5：额外附加参数
        channel.queueDeclare("hello", false, false, false, null);
        // 发布消息
        // 参数1：交换机名称
        // 参数2：队列名称
        // 参数3：传递消息额外参数
        // 参数4：消息体
        channel.basicPublish("", "hello", null, "hello rabbitmq".getBytes());
        channel.close();
        connection.close();
    }
}
