package com.projarq.trabalho01_clean.domain.service;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Primary;

import com.projarq.trabalho01_clean.domain.entity.PaymentEntity;
import com.projarq.trabalho01_clean.domain.repository.IPaymentRepository;
import com.projarq.trabalho01_clean.interfaceAdaptors.DTOs.Payment.PaymentResponseDTO;

@Primary
public class PaymentService implements IPaymentRepository {

    @Override
    public PaymentResponseDTO create(Date paymentDate, Long signatureId, double signaturePrice) {
        return null;
    }

    @Override
    public PaymentEntity edit(Long id, String name, float monthlyCost) {
        return null;
    }

    @Override
    public List<PaymentEntity> getAll() {
        return null;
    }
}
