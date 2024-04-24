package com.projarq.trabalho01_clean.interfaceAdaptors.repository;

import java.util.List;

import com.projarq.trabalho01_clean.domain.entity.PaymentEntity;
import com.projarq.trabalho01_clean.domain.repository.IPaymentRepository;

import java.util.Date;

public class PaymentRepository implements IPaymentRepository {

    @Override
    public PaymentEntity create(Long signatureId, float payedValue, Date paymentDate, String promotion) {
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
