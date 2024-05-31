package com.projarq.trabalho01_clean.interfaceAdaptors.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projarq.trabalho01_clean.domain.entity.ClientEntity;
import com.projarq.trabalho01_clean.domain.repository.IClientRepository;

@CrossOrigin(origins = "*")
@RestController
public class ClientController {
    private IClientRepository clientRepository;

    @Autowired
    public ClientController(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    /** Lista com todos os clientes cadastrados */
    @GetMapping("/servcad/clientes")
    public List<ClientEntity> getClients() {
        return clientRepository.getAllClients();
    }
}