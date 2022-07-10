package com.aplazo.calculateloan.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CalculatePaymentsRequest {
    private Double amount;
    private Integer terms;
    private Double rate;
}
