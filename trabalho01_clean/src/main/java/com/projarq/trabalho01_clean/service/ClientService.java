package com.projarq.trabalho01_clean.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.projarq.trabalho01_clean.entity.ClientEntity;
import com.projarq.trabalho01_clean.repository.IClientRepository;

public class ClientService implements IClientRepository {
    private JdbcTemplate database;

    @Autowired
    public ClientService(JdbcTemplate database) {
        this.database = database;
    }

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
