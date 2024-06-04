package com.projarq.trabalho01_clean.frameworksDrivers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.projarq.trabalho01_clean.domain.entity.ClientEntity;
import com.projarq.trabalho01_clean.interfaceAdaptors.repository.IClientRepository;

@Repository
public class ClientDatabase implements IClientRepository {
    private JdbcTemplate database;

    @Autowired
    public ClientDatabase(JdbcTemplate database) {
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
