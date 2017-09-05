package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuyf
 * @create 2017-09-04 下午4:46
 */
@RestController
public class WelcomeController {

    private String hello;

    public WelcomeController(@Value("${welcome_message}") String hello) {
        this.hello = hello;
    }

    @GetMapping("/")
    public String sayHello() {
        return hello;
    }
}
