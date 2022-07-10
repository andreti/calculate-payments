package com.aplazo.calculateloan.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@JsonPropertyOrder({"paymentNumber", "amount", "paymentDate"})
public class CalculatePaymentsResponse {
    @JsonProperty("payment_number")
    private Integer paymentNumber;

    private Double amount;

    @JsonProperty("payment_date")
    private Date paymentDate;
}
