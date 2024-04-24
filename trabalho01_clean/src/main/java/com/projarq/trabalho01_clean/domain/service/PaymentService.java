package com.projarq.trabalho01_clean.domain.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.projarq.trabalho01_clean.domain.entity.PaymentEntity;
import com.projarq.trabalho01_clean.domain.repository.IPaymentRepository;

@Repository
public class PaymentService implements IPaymentRepository {
    private JdbcTemplate database;

    @Autowired
    public PaymentService(JdbcTemplate database) {
        this.database = database;
    }

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
