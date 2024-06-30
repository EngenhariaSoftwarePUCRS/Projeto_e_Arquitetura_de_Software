package com.projarq.trabalho02_microservicos.interfaceAdaptors.useCases;

import java.util.Date;
import java.util.List;

import com.projarq.trabalho02_microservicos.domain.entity.PaymentEntity;
import com.projarq.trabalho02_microservicos.interfaceAdaptors.DTOs.Payment.PaymentResponseDTO;

public interface IPaymentUseCases {
    PaymentResponseDTO create(Long signatureId, float payedValue, Date paymentDate, String promotion) throws IllegalArgumentException;
    List<PaymentEntity> getAll();
}
