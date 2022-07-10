package com.aplazo.calculateloan.dao;

import com.aplazo.calculateloan.entity.PaymentEntity;

import java.util.List;

public interface IPaymentDao {
    List<PaymentEntity> saveAll(List<PaymentEntity> paymentEntityList);
}
