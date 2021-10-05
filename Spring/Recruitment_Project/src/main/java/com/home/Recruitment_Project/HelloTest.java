package com.home.Recruitment_Project;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloTest {
//Test Security

    @GetMapping("/")
    public String hello() {
        return "Hello";

    }
    @GetMapping("/hello")
    public String hello2() {
        return "MODERATOR";

    }

    @GetMapping("/bye")
    public String hello3() {
        return "ADMIN";
    }
}
