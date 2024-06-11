package com.projarq.sistemavendasjpa.persistencia;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface EstoqueJPA_ItfRep extends CrudRepository<ItemDeEstoque,Long>{
    List<ItemDeEstoque> findAll();
    Optional<ItemDeEstoque> findById(long id);
}
