package com.projarq.trabalho01_clean.domain.useCases.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projarq.trabalho01_clean.domain.entity.PaymentEntity;
import com.projarq.trabalho01_clean.interfaceAdaptors.DTOs.Payment.PaymentResponseDTO;
import com.projarq.trabalho01_clean.interfaceAdaptors.repository.IPaymentRepository;
import com.projarq.trabalho01_clean.interfaceAdaptors.useCases.IPaymentUseCases;

@Service
public class PaymentService implements IPaymentUseCases {
    private IPaymentRepository paymentRepository;

    @Autowired
    public PaymentService(IPaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public PaymentResponseDTO create(Date paymentDate, Long signatureId, double signaturePrice) {
        return paymentRepository.create(paymentDate, signatureId, signaturePrice);
    }

    @Override
    public PaymentEntity edit(Long id, String name, float monthlyCost) {
        return paymentRepository.edit(id, name, monthlyCost);
    }

    @Override
    public List<PaymentEntity> getAll() {
        return paymentRepository.getAll();
    }
}
