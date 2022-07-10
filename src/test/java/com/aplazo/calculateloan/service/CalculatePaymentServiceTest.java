package com.aplazo.calculateloan.service;

import com.aplazo.calculateloan.controller.dto.CalculatePaymentsRequest;
import com.aplazo.calculateloan.controller.dto.CalculatePaymentsResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CalculatePaymentServiceTest {

    @Autowired
    private CalculatePaymentService calculatePaymentService;

    @Test
    public void calculatePaymentsTestOk() {
        CalculatePaymentsRequest request = new CalculatePaymentsRequest(500000.0, 6, 2.0);
        ResponseEntity responseEntity = calculatePaymentService.calculatePayments(request);
        List<CalculatePaymentsResponse> responseList = (List<CalculatePaymentsResponse>) responseEntity.getBody();
        assertTrue(responseEntity.getBody() != null);
        assertEquals(responseList.size(), request.getTerms());
    }

    @Test
    public void invalidRequestTestTrue( ){
        CalculatePaymentsRequest request = new CalculatePaymentsRequest(500000.0, 6, 2.0);
        assertFalse(calculatePaymentService.invalidRequest(request));
    }

    @Test
    public void invalidRequestTestFalse( ){
        CalculatePaymentsRequest request = new CalculatePaymentsRequest(0.0, 6, 2.0);
        assertTrue(calculatePaymentService.invalidRequest(request));
    }
}
