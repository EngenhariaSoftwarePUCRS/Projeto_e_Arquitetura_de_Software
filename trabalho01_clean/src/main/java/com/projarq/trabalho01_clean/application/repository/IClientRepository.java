package com.projarq.trabalho01_clean.application.repository;

import java.util.List;

import com.projarq.trabalho01_clean.application.entity.ClientEntity;

public interface IClientRepository{
    ClientEntity create(Long id, String name, String email);
    List<ClientEntity> getAllClients();
    ClientEntity edit(Long id, String name, String email); //Fazer isso opcional!!!
}