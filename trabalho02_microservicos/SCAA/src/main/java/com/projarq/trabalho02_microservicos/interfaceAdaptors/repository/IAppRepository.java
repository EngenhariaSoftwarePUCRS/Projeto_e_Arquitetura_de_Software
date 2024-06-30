package com.projarq.trabalho02_microservicos.interfaceAdaptors.repository;

import java.util.List;

import com.projarq.trabalho02_microservicos.domain.entity.AppEntity;
import com.projarq.trabalho02_microservicos.domain.entity.ClientEntity;
import com.projarq.trabalho02_microservicos.interfaceAdaptors.DTOs.App.EditAppDTO;

public interface IAppRepository{
    AppEntity create(String name, float monthlyCost);
    List<AppEntity> getAll();
    AppEntity getApp(Long appId);
    List<ClientEntity> getAllClients(Long appId);
    AppEntity edit(Long id, EditAppDTO updatedAppEntity);
    AppEntity updateMonthlyCost(Long appId, float monthlyCost);
}
