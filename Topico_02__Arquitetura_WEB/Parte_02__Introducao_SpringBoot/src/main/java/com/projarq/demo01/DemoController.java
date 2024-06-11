package com.projarq.demo01;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("")
    @CrossOrigin(origins="*")
    public String welcomeMessage() {
        return "Bem-vindo a biblioteca central";
    }
}
