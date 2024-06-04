package com.projarq.trabalho01_clean.interfaceAdaptors.repository;

import java.util.List;

import com.projarq.trabalho01_clean.domain.entity.AppEntity;
import com.projarq.trabalho01_clean.domain.entity.ClientEntity;

public interface IAppRepository{
    AppEntity create(String name, float monthlyCost);
    List<AppEntity> getAll();
    List<ClientEntity> getAllClients(Long appId);
    AppEntity edit(Long id, AppEntity updatedAppEntity);
    AppEntity updateMonthlyCost(Long appId, float monthlyCost);
}
