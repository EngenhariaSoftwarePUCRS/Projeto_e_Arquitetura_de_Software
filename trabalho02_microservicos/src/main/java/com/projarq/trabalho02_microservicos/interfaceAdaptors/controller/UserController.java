package com.projarq.trabalho02_microservicos.interfaceAdaptors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.projarq.trabalho02_microservicos.interfaceAdaptors.useCases.IUserUseCases;

@RestController
public class UserController {
    private IUserUseCases userService;

    @Autowired
    public UserController(IUserUseCases userService) {
        this.userService = userService;
    }
}
