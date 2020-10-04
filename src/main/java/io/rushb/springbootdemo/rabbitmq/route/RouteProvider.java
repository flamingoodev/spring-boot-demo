package io.rushb.springbootdemo.rabbitmq.route;

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
public class RouteProvider {
    private final RabbitTemplate rabbitTemplate;

    public RouteProvider(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/send/route")
    public String send() {
        rabbitTemplate.convertAndSend("directs", "info", "route模型");
        rabbitTemplate.convertAndSend("directs", "error", "route模型" + " error");
        return "success";
    }
}
