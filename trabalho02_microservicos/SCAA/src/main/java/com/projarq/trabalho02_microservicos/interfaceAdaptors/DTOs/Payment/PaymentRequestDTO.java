package com.projarq.trabalho02_microservicos.interfaceAdaptors.DTOs.Payment;

import lombok.Data;

@Data
public class PaymentRequestDTO {
    private Long signatureId;
    private float payedValue;
    private String promotion;
}
