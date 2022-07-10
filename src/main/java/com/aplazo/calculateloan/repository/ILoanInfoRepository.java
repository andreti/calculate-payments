package com.aplazo.calculateloan.repository;

import com.aplazo.calculateloan.entity.LoanInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoanInfoRepository extends JpaRepository<LoanInfoEntity, Long> {
}
