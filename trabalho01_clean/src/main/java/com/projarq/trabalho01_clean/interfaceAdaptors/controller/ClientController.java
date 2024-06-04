package com.projarq.trabalho01_clean.interfaceAdaptors.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projarq.trabalho01_clean.domain.entity.ClientEntity;
import com.projarq.trabalho01_clean.interfaceAdaptors.useCases.IClientUseCases;

@CrossOrigin(origins = "*")
@RestController
public class ClientController {
    private IClientUseCases clientService;

    @Autowired
    public ClientController(IClientUseCases clientService) {
        this.clientService = clientService;
    }

    /** Lista com todos os clientes cadastrados */
    @GetMapping("/servcad/clientes")
    public List<ClientEntity> getClients() {
        return clientService.getAllClients();
    }
}
