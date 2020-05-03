package io.rushb.springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloWorld
 *
 * @author <a href="mailto:flamingodev@outlook.com">FLAMINGO</a>
 * @since 2020/5/3 19:53
 */
@RestController
@RequestMapping("/hello")
public class HelloWorldController {
    @GetMapping("hello-world")
    public String helloWorld() {
        return "Hello World!";
    }
}
