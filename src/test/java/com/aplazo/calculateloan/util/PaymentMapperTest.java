package com.aplazo.calculateloan.util;

import com.aplazo.calculateloan.controller.dto.CalculatePaymentsResponse;
import com.aplazo.calculateloan.entity.PaymentEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PaymentMapperTest {

    @Test
    public void toLoanInfoEntityTest() {
        CalculatePaymentsResponse dto = new CalculatePaymentsResponse(1, 50000.0, new Date());
        PaymentEntity paymentEntity = PaymentMapper.toPaymentEntity(dto);
        assertTrue(paymentEntity != null);
        assertEquals(paymentEntity.getPaymentNumber(), dto.getPaymentNumber());
    }
}
