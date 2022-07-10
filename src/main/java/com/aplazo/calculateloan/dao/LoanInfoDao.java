package com.aplazo.calculateloan.dao;

import com.aplazo.calculateloan.entity.LoanInfoEntity;
import com.aplazo.calculateloan.repository.ILoanInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanInfoDao implements ILoanDao {

    @Autowired
    private ILoanInfoRepository iLoanInfoRepository;

    @Override
    public LoanInfoEntity save(LoanInfoEntity entity) {
        return iLoanInfoRepository.saveAndFlush(entity);
    }

}
