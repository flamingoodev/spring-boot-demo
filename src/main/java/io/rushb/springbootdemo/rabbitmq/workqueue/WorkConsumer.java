package io.rushb.springbootdemo.rabbitmq.workqueue;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息监听
 * 模型二：工作队列，自带负载均衡（轮询），消息只会被一个消费者消费
 * "@Queue("value")" 默认是持久化，非独占，非自动删除队列
 *
 * @author <a href="mailto:flamingodev@outlook.com">FLAMINGO</a>
 * @since 2020/10/4 18:06
 */
@Component
public class WorkConsumer {

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receiver1(String msg) {
        System.out.println("msg1 = " + msg);
    }

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receiver2(String msg) {
        System.out.println("msg2 = " + msg);
    }
}
