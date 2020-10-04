package io.rushb.springbootdemo.rabbitmq.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息监听
 * 模型五：动态路由，订阅模式
 * "@Queue("value")" 默认是持久化，非独占，非自动删除队列
 *
 * @author <a href="mailto:flamingodev@outlook.com">FLAMINGO</a>
 * @since 2020/10/4 18:06
 */
@Component
public class TopicConsumer {
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(name = "topics", type = ExchangeTypes.TOPIC),
                    key = {"user.save", "user.*"}
            )
    })
    public void receiver1(String msg) {
        System.out.println("msg1 = " + msg);
    }
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(name = "topics", type = ExchangeTypes.TOPIC),
                    key = {"order.#", "produce.#"}
            )
    })
    public void receiver2(String msg) {
        System.out.println("msg2 = " + msg);
    }
}
