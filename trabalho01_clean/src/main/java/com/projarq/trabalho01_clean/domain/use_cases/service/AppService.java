package com.projarq.trabalho01_clean.domain.use_cases.service;

import java.util.List;

import org.springframework.context.annotation.Primary;

import com.projarq.trabalho01_clean.domain.entity.AppEntity;
import com.projarq.trabalho01_clean.domain.entity.ClientEntity;
import com.projarq.trabalho01_clean.interfaceAdaptors.repository.IAppRepository;

@Primary
public class AppService implements IAppRepository {

    @Override
    public AppEntity create(String name, float monthlyCost) {
        return null;
    }

    @Override
    public AppEntity edit(Long id, AppEntity updatedAppEntity) {
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
