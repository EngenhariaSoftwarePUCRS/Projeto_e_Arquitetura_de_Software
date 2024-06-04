package com.projarq.trabalho01_clean.interfaceAdaptors.repository;

import java.util.Date;
import java.util.List;

import com.projarq.trabalho01_clean.domain.entity.PaymentEntity;
import com.projarq.trabalho01_clean.interfaceAdaptors.DTOs.Payment.PaymentResponseDTO;

public interface IPaymentRepository{
    PaymentResponseDTO create(Date paymentDate, Long signatureId, double signaturePrice);
    List<PaymentEntity> getAll();
    PaymentEntity edit(Long id, String name, float monthlyCost); //Fazer isso opcional!!!
}
