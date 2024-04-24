package com.projarq.trabalho01_clean.interfaceAdaptors.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projarq.trabalho01_clean.domain.entity.PaymentEntity;
import com.projarq.trabalho01_clean.domain.repository.IPaymentRepository;

@RestController
public class PaymentController {
    private IPaymentRepository paymentRepository;

    @Autowired
    public PaymentController() {
        
    }

    @PostMapping("/registrarpagamento") // Solicita o registro de um pagamento
    @CrossOrigin(origins = "*")
    public PaymentEntity addPayment(
        @RequestBody final Date date,
        @RequestBody final Long signatureId,
        @RequestBody final float monthlyCost,
        @RequestBody final String promotion
    ) {
        return paymentRepository.create(signatureId, monthlyCost, date, promotion);
    }
}