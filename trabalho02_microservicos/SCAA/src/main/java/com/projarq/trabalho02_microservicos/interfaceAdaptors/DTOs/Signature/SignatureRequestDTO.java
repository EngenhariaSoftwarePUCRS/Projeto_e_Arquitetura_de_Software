package com.projarq.trabalho02_microservicos.interfaceAdaptors.DTOs.Signature;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignatureRequestDTO {
    private Long clientId;
    private Long appId;
}
