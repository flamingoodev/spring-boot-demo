package io.rushb.springbootdemo.rabbitmq.topic;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消息生产者
 *
 * @author <a href="mailto:flamingodev@outlook.com">FLAMINGO</a>
 * @since 2020/10/4 18:09
 */
@RestController
@RequestMapping("/message")
public class TopicProvider {
    private final RabbitTemplate rabbitTemplate;

    public TopicProvider(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/send/topic")
    public String send() {
        rabbitTemplate.convertAndSend("topics", "user.save", "topic模型");
        rabbitTemplate.convertAndSend("topics", "order.delete.1", "topic模型");
        rabbitTemplate.convertAndSend("topics", "produce.delete.1", "topic模型");
        return "success";
    }
}
