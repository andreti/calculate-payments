package com.aplazo.calculateloan.repository;

import com.aplazo.calculateloan.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaymentRepository extends JpaRepository<PaymentEntity, Long> {
}
