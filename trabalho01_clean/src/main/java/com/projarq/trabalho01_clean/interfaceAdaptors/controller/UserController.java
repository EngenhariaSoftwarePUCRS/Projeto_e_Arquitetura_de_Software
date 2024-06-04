package com.projarq.trabalho01_clean.interfaceAdaptors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.projarq.trabalho01_clean.interfaceAdaptors.repository.IUserRepository;

@RestController
public class UserController {
    private IUserRepository userRepository;

    @Autowired
    public UserController(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
}