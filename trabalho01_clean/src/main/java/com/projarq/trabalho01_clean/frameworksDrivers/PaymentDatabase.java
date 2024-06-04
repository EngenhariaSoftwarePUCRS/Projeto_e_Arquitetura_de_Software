package com.projarq.trabalho01_clean.frameworksDrivers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.projarq.trabalho01_clean.domain.entity.PaymentEntity;
import com.projarq.trabalho01_clean.interfaceAdaptors.DTOs.Payment.PaymentResponseDTO;
import com.projarq.trabalho01_clean.interfaceAdaptors.repository.IPaymentRepository;

import java.util.Date;

@Repository
public class PaymentDatabase implements IPaymentRepository {
    private JdbcTemplate database;

    @Autowired
    public PaymentDatabase(JdbcTemplate database) {
        this.database = database;
    }

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
