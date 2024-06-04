package com.projarq.trabalho01_clean.domain.use_cases.service;

import java.util.List;

import org.springframework.context.annotation.Primary;

import com.projarq.trabalho01_clean.domain.entity.ClientEntity;
import com.projarq.trabalho01_clean.interfaceAdaptors.repository.IClientRepository;

@Primary
public class ClientService implements IClientRepository {

    @Override
    public ClientEntity create(Long id, String name, String email) {
        return null;
    }

    @Override
    public ClientEntity edit(Long id, String name, String email) {
        return null;
    }

    @Override
    public List<ClientEntity> getAllClients() {
        return null;
    }

    
}
