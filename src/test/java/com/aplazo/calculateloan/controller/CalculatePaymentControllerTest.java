package com.aplazo.calculateloan.controller;

import com.aplazo.calculateloan.controller.dto.CalculatePaymentsRequest;
import com.aplazo.calculateloan.controller.dto.CalculatePaymentsResponse;
import com.aplazo.calculateloan.service.CalculatePaymentServiceTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CalculatePaymentControllerTest {

    @Autowired
    private CalculatePaymentController calculatePaymentController;

    @Test
    public void calculatePaymentsOK() {
        CalculatePaymentsRequest request = new CalculatePaymentsRequest(500000.0, 6, 2.0);
        ResponseEntity responseEntity = calculatePaymentController.calculatePayments(request);
        List<CalculatePaymentsResponse> responseList = (List<CalculatePaymentsResponse>) responseEntity.getBody();

        assertTrue(responseEntity.getBody() != null);
        assertEquals(responseList.size(), request.getTerms());
    }

    @Test
    public void calculatePaymentsError() {
        CalculatePaymentsRequest request = new CalculatePaymentsRequest(1.0, 1, 0.0);
        ResponseEntity responseEntity = calculatePaymentController.calculatePayments(request);
        assertTrue(responseEntity.getBody() != null);
        assertTrue(responseEntity.getStatusCode() == HttpStatus.BAD_REQUEST);
    }
}
