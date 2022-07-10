package com.aplazo.calculateloan.controller;

import com.aplazo.calculateloan.controller.dto.CalculatePaymentsRequest;
import com.aplazo.calculateloan.service.CalculatePaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate-payments")
public class CalculatePaymentController {

    @Autowired
    private CalculatePaymentService calculatePaymentService;

    @PostMapping
    public ResponseEntity<?> calculatePayments(@RequestBody CalculatePaymentsRequest request) {
        return calculatePaymentService.calculatePayments(request);
    }
}
