package io.rushb.springbootdemo.rabbitmq.fanout;

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
public class FanoutProvider {
    private final RabbitTemplate rabbitTemplate;

    public FanoutProvider(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/send/fanout")
    public String send() {
        rabbitTemplate.convertAndSend("logs", "", "fanout模型");
        return "success";
    }
}
