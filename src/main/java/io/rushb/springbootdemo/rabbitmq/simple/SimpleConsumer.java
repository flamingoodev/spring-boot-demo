package io.rushb.springbootdemo.rabbitmq.simple;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息监听
 * 模型一：点对点直连模型
 * "@Queue("value")" 默认是持久化，非独占，非自动删除队列
 *
 * @author <a href="mailto:flamingodev@outlook.com">FLAMINGO</a>
 * @since 2020/10/4 18:06
 */
@Component
@RabbitListener(queuesToDeclare = @Queue("hello"))
public class SimpleConsumer {
    @RabbitHandler
    public void receiver(String msg) {
        System.out.println("msg = " + msg);
    }
}
