package com.projarq.trabalho01_clean.domain.useCases.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projarq.trabalho01_clean.domain.entity.AppEntity;
import com.projarq.trabalho01_clean.domain.entity.ClientEntity;
import com.projarq.trabalho01_clean.interfaceAdaptors.DTOs.App.EditAppDTO;
import com.projarq.trabalho01_clean.interfaceAdaptors.repository.IAppRepository;
import com.projarq.trabalho01_clean.interfaceAdaptors.useCases.IAppUseCases;

@Service
public class AppService implements IAppUseCases {
    private IAppRepository appRepository;

    @Autowired
    public AppService(IAppRepository appRepository) {
        this.appRepository = appRepository;
    }

    @Override
    public AppEntity create(String name, float monthlyCost) {
        return appRepository.create(name, monthlyCost);
    }

    @Override
    public AppEntity edit(Long id, EditAppDTO updatedAppEntity) {
        return appRepository.edit(id, updatedAppEntity);
    }

    @Override
    public List<AppEntity> getAll() {
        return appRepository.getAll();
    }

    @Override
    public List<ClientEntity> getAllClients(Long appId) {
        return appRepository.getAllClients(appId);
    }

    @Override
    public AppEntity updateMonthlyCost(Long appId, float monthlyCost) {
        return appRepository.updateMonthlyCost(appId, monthlyCost);
    }
}
