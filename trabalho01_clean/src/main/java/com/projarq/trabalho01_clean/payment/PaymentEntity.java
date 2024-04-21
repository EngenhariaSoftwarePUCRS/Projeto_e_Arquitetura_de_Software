package com.projarq.trabalho01_clean.payment;

import java.time.LocalDate;

import com.projarq.trabalho01_clean.signature.SignatureEntity;

public class PaymentEntity {

    //Identificador único do pagamento
    private Long id;
    //Assinatura paga
    private SignatureEntity signature;
    //Valor pago
    private float payedValue;
    //Data em que o pagamento foi efetuado
    private LocalDate paymentDate;
    //Código correspondente a uma promoção usada no pagamento. Pode ser um "none" no caso de não ser usado código nenhum
    private String promotion;
}