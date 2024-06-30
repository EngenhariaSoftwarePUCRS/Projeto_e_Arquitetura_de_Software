package com.projarq.trabalho02_microservicos.interfaceAdaptors.DTOs.Client;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateClientDTO {
    private String name;
    private String email;
}
