package com.projarq.trabalho01_clean.repository;

import java.util.List;
import java.util.Date;

import com.projarq.trabalho01_clean.entity.PaymentEntity;

public interface IPaymentRepository{
    PaymentEntity create(Long signatureId, float payedValue, Date paymentDate, String promotion);
    List<PaymentEntity> getAll();
    PaymentEntity edit(Long id, String name, float monthlyCost); //Fazer isso opcional!!!
}
