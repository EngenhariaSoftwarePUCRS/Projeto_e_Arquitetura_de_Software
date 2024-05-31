package com.projarq.trabalho01_clean.interfaceAdaptors.DTOs.Payment;

import java.sql.Date;

public class PaymentResponseDTO {
    private enum PaymentStatus {
        PAGAMENTO_OK, VALOR_INCORRETO;
    }

    private PaymentStatus status;
    private Date paymentDate;
    private float refoundValue;

    public PaymentResponseDTO(Date paymentDate, float refoundValue) {
        this.paymentDate = paymentDate;
        this.refoundValue = refoundValue;
        this.status = PaymentStatus.PAGAMENTO_OK;
    }
}
