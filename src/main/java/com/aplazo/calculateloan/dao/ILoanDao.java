package com.aplazo.calculateloan.dao;

import com.aplazo.calculateloan.entity.LoanInfoEntity;

public interface ILoanDao {
    LoanInfoEntity save(LoanInfoEntity entity);
}
