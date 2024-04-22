package com.projarq.trabalho01_clean.repository;

import java.util.List;

import com.projarq.trabalho01_clean.entity.ClientEntity;

public interface IClientRepository{
    ClientEntity create(Long id, String name, String email);
    List<ClientEntity> getAllClients();
    ClientEntity edit(Long id, String name, String email); //Fazer isso opcional!!!
}