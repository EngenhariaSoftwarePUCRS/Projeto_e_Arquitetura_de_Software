package com.projarq.trabalho01_clean.interfaceAdaptors.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projarq.trabalho01_clean.domain.repository.IPaymentRepository;
import com.projarq.trabalho01_clean.interfaceAdaptors.DTOs.Payment.PaymentRequestDTO;
import com.projarq.trabalho01_clean.interfaceAdaptors.DTOs.Payment.PaymentResponseDTO;

@CrossOrigin(origins = "*")
@RestController
public class PaymentController {
    private IPaymentRepository paymentRepository;

    @Autowired
    public PaymentController(IPaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    /** Solicita o registro de um pagamento */
    @PostMapping("/registrarpagamento")
    public PaymentResponseDTO addPayment(@RequestBody final PaymentRequestDTO paymentDTO) {
        @SuppressWarnings("deprecation")
        Date paymentDate = new Date(
            paymentDTO.getYear() - 1900,
            paymentDTO.getMonth() - 1,
            paymentDTO.getDay()
        );
        return paymentRepository.create(
            paymentDate,
            paymentDTO.getSignatureId(),
            paymentDTO.getSignaturePrice()
        );
    }
}