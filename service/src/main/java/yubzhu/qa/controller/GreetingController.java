package yubzhu.qa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yubzhu.qa.service.Greeting;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by 朱宇斌 on 2017/12/14
 */

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(value="name", defaultValue="world") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
