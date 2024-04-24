package com.projarq.trabalho01_clean.domain.repository;

import java.util.List;

import com.projarq.trabalho01_clean.domain.entity.PaymentEntity;

import java.util.Date;

public interface IPaymentRepository{
    PaymentEntity create(Long signatureId, float payedValue, Date paymentDate, String promotion);
    List<PaymentEntity> getAll();
    PaymentEntity edit(Long id, String name, float monthlyCost); //Fazer isso opcional!!!
}
