package com.aplazo.calculateloan.service;

import com.aplazo.calculateloan.controller.dto.CalculatePaymentsRequest;
import org.springframework.http.ResponseEntity;

public interface ICalculatePayments {
    ResponseEntity<?> calculatePayments(CalculatePaymentsRequest request);
}
