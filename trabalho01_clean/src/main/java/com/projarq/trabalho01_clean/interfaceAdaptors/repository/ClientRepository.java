package com.projarq.trabalho01_clean.interfaceAdaptors.repository;

import java.util.List;

import com.projarq.trabalho01_clean.domain.entity.ClientEntity;
import com.projarq.trabalho01_clean.domain.repository.IClientRepository;

public class ClientRepository implements IClientRepository {

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
