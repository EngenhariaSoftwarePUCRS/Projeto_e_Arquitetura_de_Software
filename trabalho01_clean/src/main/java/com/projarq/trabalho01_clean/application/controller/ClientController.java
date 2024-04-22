package com.projarq.trabalho01_clean.application.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.projarq.trabalho01_clean.application.entity.ClientEntity;
import com.projarq.trabalho01_clean.application.repository.IClientRepository;

@RestController
public class ClientController {
    private IClientRepository clientRepository;

    public ClientController() {
        
    }

    @GetMapping("/servcad/clientes")
    @CrossOrigin(origins = "*")
    public List<ClientEntity> getClients() {
        return clientRepository.getAllClients();
    }
}