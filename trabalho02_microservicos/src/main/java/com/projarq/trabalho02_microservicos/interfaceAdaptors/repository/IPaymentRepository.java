package com.projarq.trabalho02_microservicos.interfaceAdaptors.repository;

import java.util.Date;
import java.util.List;

import com.projarq.trabalho02_microservicos.domain.entity.PaymentEntity;

public interface IPaymentRepository{
    PaymentEntity create(Long signatureId, float signaturePrice, Date paymentDate, String promotion);
    List<PaymentEntity> getAll();
}
