package com.projarq.trabalho01_clean.interfaceAdaptors.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<PaymentResponseDTO> addPayment(@RequestBody final PaymentRequestDTO paymentDTO) {
        try {
            PaymentResponseDTO paymentResponse = paymentService.create(
                paymentDTO.getSignatureId(),
                paymentDTO.getPayedValue(),
                new Date(),
                paymentDTO.getPromotion()
            );
            return new ResponseEntity<>(paymentResponse, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
