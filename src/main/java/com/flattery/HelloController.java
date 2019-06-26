package com.flattery;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController extends BaseController{

    @RequestMapping("/hello")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/test")
    public String test() {
        return "TestPage";
    }

    @RequestMapping("/tobias")
    public String tobias() {
        return "Tobias!";
    }

    //TODO



}