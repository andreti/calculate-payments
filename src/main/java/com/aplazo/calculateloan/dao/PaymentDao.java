package com.aplazo.calculateloan.dao;

import com.aplazo.calculateloan.entity.PaymentEntity;
import com.aplazo.calculateloan.repository.IPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentDao implements IPaymentDao {

    @Autowired
    private IPaymentRepository iPaymentRepository;

    @Override
    public List<PaymentEntity> saveAll(List<PaymentEntity> entityList) {
        return iPaymentRepository.saveAll(entityList);
    }

}
