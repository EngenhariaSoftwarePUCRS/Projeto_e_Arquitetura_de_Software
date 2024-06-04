package com.projarq.trabalho01_clean.domain.useCases.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projarq.trabalho01_clean.domain.entity.ClientEntity;
import com.projarq.trabalho01_clean.interfaceAdaptors.repository.IClientRepository;
import com.projarq.trabalho01_clean.interfaceAdaptors.useCases.IClientUseCases;

@Service
public class ClientService implements IClientUseCases {
    private IClientRepository clientRepository;

    @Autowired
    public ClientService(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientEntity create(Long id, String name, String email) {
        return clientRepository.create(id, name, email);
    }

    @Override
    public ClientEntity edit(Long id, String name, String email) {
        return clientRepository.edit(id, name, email);
    }

    @Override
    public List<ClientEntity> getAllClients() {
        return clientRepository.getAllClients();
    }   
}
