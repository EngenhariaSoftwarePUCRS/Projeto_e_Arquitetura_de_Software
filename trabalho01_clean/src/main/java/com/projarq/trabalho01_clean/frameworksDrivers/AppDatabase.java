package com.projarq.trabalho01_clean.frameworksDrivers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.projarq.trabalho01_clean.domain.entity.AppEntity;
import com.projarq.trabalho01_clean.domain.entity.ClientEntity;
import com.projarq.trabalho01_clean.interfaceAdaptors.repository.IAppRepository;

@Repository
public class AppDatabase implements IAppRepository {
    private JdbcTemplate database;

    @Autowired
    public AppDatabase(JdbcTemplate database) {
        this.database = database;
    }

    @Override
    public AppEntity create(String name, float monthlyCost) {
        return null;
    }

    @Override
    public AppEntity edit(Long id, AppEntity app) {
        return null;
    }

    @Override
    public List<AppEntity> getAll() {
        return null;
    }

    @Override
    public List<ClientEntity> getAllClients(Long appId) {
        return null;
    }

    @Override
    public AppEntity updateMonthlyCost(Long appId, float monthlyCost) {
        return null;
    }
}
