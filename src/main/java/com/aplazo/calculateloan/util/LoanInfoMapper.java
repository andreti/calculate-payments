package com.aplazo.calculateloan.util;

import com.aplazo.calculateloan.controller.dto.CalculatePaymentsRequest;
import com.aplazo.calculateloan.entity.LoanInfoEntity;

public class LoanInfoMapper {

    public static LoanInfoEntity toLoanInfoEntity(CalculatePaymentsRequest dto) {
        LoanInfoEntity loanInfoEntity = new LoanInfoEntity();
        loanInfoEntity.setAmount(dto.getAmount());
        loanInfoEntity.setRate(dto.getRate());
        loanInfoEntity.setTerms(dto.getTerms());
        return loanInfoEntity;
    }
}
