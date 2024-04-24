package com.projarq.trabalho01_clean.interfaceAdaptors.repository;

import java.util.List;

import com.projarq.trabalho01_clean.domain.entity.AppEntity;
import com.projarq.trabalho01_clean.domain.entity.ClientEntity;
import com.projarq.trabalho01_clean.domain.repository.IAppRepository;

public class AppRepository implements IAppRepository {

    @Override
    public AppEntity create(Long id, String name, float monthlyCost) {
        return null;
    }

    @Override
    public AppEntity edit(Long id, String name, float monthlyCost) {
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
