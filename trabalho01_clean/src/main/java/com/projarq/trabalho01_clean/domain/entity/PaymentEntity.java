package com.projarq.trabalho01_clean.domain.entity;

import java.util.Date;

import com.projarq.trabalho01_clean.interfaceAdaptors.DTOs.Payment.PaymentStatus;

import lombok.Data;

@Data
public class PaymentEntity {

    //Identificador único do pagamento
    private Long id;
    //Assinatura paga
    private Long signatureId;
    //Valor pago
    private float payedValue;
    //Data em que o pagamento foi efetuado
    private Date paymentDate;
    //Código correspondente a uma promoção usada no pagamento. Pode ser um "none" no caso de não ser usado código nenhum
    private String promotion;
    //Status do pagamento
    private PaymentStatus status;

    public PaymentEntity(Long id, Long signatureId, float payedValue, Date paymentDate) {
        this.id = id;
        this.signatureId = signatureId;
        this.payedValue = payedValue;
        this.paymentDate = paymentDate;
    }
}
