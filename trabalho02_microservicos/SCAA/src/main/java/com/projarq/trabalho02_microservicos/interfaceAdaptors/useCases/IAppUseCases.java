package com.projarq.trabalho02_microservicos.interfaceAdaptors.useCases;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import com.projarq.trabalho02_microservicos.domain.entity.AppEntity;
import com.projarq.trabalho02_microservicos.domain.entity.ClientEntity;
import com.projarq.trabalho02_microservicos.interfaceAdaptors.DTOs.App.EditAppDTO;

public interface IAppUseCases {
    AppEntity create(String name, float monthlyCost);
    List<AppEntity> getAll();
    AppEntity getApp(Long appId) throws EmptyResultDataAccessException;
    List<ClientEntity> getAllClients(Long appId) throws IllegalArgumentException;
    AppEntity edit(Long id, EditAppDTO updatedAppEntity) throws IllegalArgumentException;
    AppEntity updateMonthlyCost(Long appId, float monthlyCost) throws IllegalArgumentException;
}
