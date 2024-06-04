package com.projarq.trabalho01_clean.interfaceAdaptors.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projarq.trabalho01_clean.interfaceAdaptors.DTOs.Payment.PaymentRequestDTO;
import com.projarq.trabalho01_clean.interfaceAdaptors.DTOs.Payment.PaymentResponseDTO;
import com.projarq.trabalho01_clean.interfaceAdaptors.useCases.IPaymentUseCases;

@CrossOrigin(origins = "*")
@RestController
public class PaymentController {
    private IPaymentUseCases paymentService;

    @Autowired
    public PaymentController(IPaymentUseCases paymentService) {
        this.paymentService = paymentService;
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
        return paymentService.create(
            paymentDate,
            paymentDTO.getSignatureId(),
            paymentDTO.getSignaturePrice()
        );
    }
}
