package com.projarq.trabalho02_microservicos.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientEntity { 
    
    //Código identificador do cliente
    private Long id;
    //Nome do cliente
    private String name;
    //Email do cliente
    private String email;
}