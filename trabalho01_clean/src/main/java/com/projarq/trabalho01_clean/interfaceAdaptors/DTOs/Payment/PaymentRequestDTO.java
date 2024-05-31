package com.projarq.trabalho01_clean.interfaceAdaptors.DTOs.Payment;

import lombok.Data;

@Data
public class PaymentRequestDTO {
    private int day;
    private int month;
    private int year;
    private Long signatureId;
    private double signaturePrice;
}
