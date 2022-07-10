package com.aplazo.calculateloan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class LoanInfoEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(length = 10, nullable = false)
    private Integer terms;

    @Column(nullable = false)
    private Double rate;
}
