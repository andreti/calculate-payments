package com.aplazo.calculateloan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class PaymentEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(length = 10, nullable = false)
    private Integer paymentNumber;

    @Column(nullable = false)
    private Date paymentDate;

    @ManyToOne(cascade = CascadeType.REMOVE, optional = false, fetch = FetchType.LAZY)
    private LoanInfoEntity loanInfoEntity;
}
