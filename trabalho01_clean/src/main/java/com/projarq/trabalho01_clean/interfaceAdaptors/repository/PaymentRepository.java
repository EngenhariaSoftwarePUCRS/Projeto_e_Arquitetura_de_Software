package com.projarq.trabalho01_clean.interfaceAdaptors.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.projarq.trabalho01_clean.domain.entity.PaymentEntity;
import com.projarq.trabalho01_clean.domain.repository.IPaymentRepository;
import com.projarq.trabalho01_clean.interfaceAdaptors.DTOs.Payment.PaymentResponseDTO;

import java.util.Date;

@Repository
public class PaymentRepository implements IPaymentRepository {

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
