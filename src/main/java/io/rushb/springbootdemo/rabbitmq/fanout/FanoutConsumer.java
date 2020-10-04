package io.rushb.springbootdemo.rabbitmq.workqueue;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息监听
 * 模型三：发布订阅模型（广播），需要交换机
 * "@Queue("value")" 默认是持久化，非独占，非自动删除队列
 *
 * @author <a href="mailto:flamingodev@outlook.com">FLAMINGO</a>
 * @since 2020/10/4 18:06
 */
@Component
public class FanoutConsumer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, // 创建临时队列
                    exchange = @Exchange(value = "logs", type = ExchangeTypes.FANOUT) // 绑定的交换机和交换机类型
            )
    })
    public void receiver1(String msg) {
        System.out.println("msg1 = " + msg);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, // 创建临时队列
                    exchange = @Exchange(value = "logs", type = ExchangeTypes.FANOUT) // 绑定的交换机和交换机类型
            )
    })
    public void receiver2(String msg) {
        System.out.println("msg2 = " + msg);
    }
}
