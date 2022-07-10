package com.aplazo.calculateloan.util;

import com.aplazo.calculateloan.controller.dto.CalculatePaymentsResponse;
import com.aplazo.calculateloan.entity.PaymentEntity;

public class PaymentMapper {

    public static PaymentEntity toPaymentEntity(CalculatePaymentsResponse dto) {
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setAmount(dto.getAmount());
        paymentEntity.setPaymentDate(dto.getPaymentDate());
        paymentEntity.setPaymentNumber(dto.getPaymentNumber());
        return paymentEntity;
    }
}
