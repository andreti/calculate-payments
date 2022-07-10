package com.aplazo.calculateloan.util;

import com.aplazo.calculateloan.controller.dto.CalculatePaymentsRequest;
import com.aplazo.calculateloan.entity.LoanInfoEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LoanInfoMapperTest {

    @Test
    public void toLoanInfoEntityTest() {
        CalculatePaymentsRequest dto = new CalculatePaymentsRequest(500000.0, 6, 2.0);
        LoanInfoEntity loanInfoEntity = LoanInfoMapper.toLoanInfoEntity(dto);
        assertTrue(loanInfoEntity != null);
        assertEquals(loanInfoEntity.getAmount(), dto.getAmount());
    }
}
