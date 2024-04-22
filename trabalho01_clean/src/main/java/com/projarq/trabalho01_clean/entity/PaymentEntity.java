package com.projarq.trabalho01_clean.entity;

import java.util.Date;

import com.projarq.trabalho01_clean.entity.SignatureEntity;

public class PaymentEntity {

    //Identificador único do pagamento
    private Long id;
    //Assinatura paga
    private SignatureEntity signature;
    //Valor pago
    private float payedValue;
    //Data em que o pagamento foi efetuado
    private Date paymentDate;
    //Código correspondente a uma promoção usada no pagamento. Pode ser um "none" no caso de não ser usado código nenhum
    private String promotion;
    //Status do pagamento
    private Status status;
}

enum Status {
    PAGAMENTO_OK, PROMOCAO_INVALIDA, VALOR_INCORRETO
}