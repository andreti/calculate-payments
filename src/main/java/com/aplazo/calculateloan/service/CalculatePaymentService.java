package com.aplazo.calculateloan.service;

import com.aplazo.calculateloan.controller.dto.CalculatePaymentsRequest;
import com.aplazo.calculateloan.controller.dto.CalculatePaymentsResponse;
import com.aplazo.calculateloan.dao.ILoanDao;
import com.aplazo.calculateloan.dao.IPaymentDao;
import com.aplazo.calculateloan.entity.LoanInfoEntity;
import com.aplazo.calculateloan.entity.PaymentEntity;
import com.aplazo.calculateloan.util.LoanInfoMapper;
import com.aplazo.calculateloan.util.PaymentMapper;
import com.aplazo.calculateloan.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CalculatePaymentService implements ICalculatePayments {

    @Autowired
    private ILoanDao iLoanDao;

    @Autowired
    private IPaymentDao iPaymentDao;

    @Override
    public ResponseEntity<?> calculatePayments(CalculatePaymentsRequest request) {
        try {

            if(invalidRequest(request))
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Resquest: terms > 0 , amount > 0 , 0 < rate <= 100");

            LoanInfoEntity loanInfoEntity = saveLoanInfoEntity(request);

            Double amountWeekly = Util.calculatePay(request.getAmount(), request.getRate(), request.getTerms());
            Date paymentDate = new Date();

            List<CalculatePaymentsResponse> responseList = new ArrayList<>();
            List<PaymentEntity> paymentEntityList = new ArrayList<>();

            for (int i = 1; i <= request.getTerms(); i++) {
                CalculatePaymentsResponse calculatePaymentsResponse =
                        new CalculatePaymentsResponse(i, amountWeekly, paymentDate);
                responseList.add(calculatePaymentsResponse);

                PaymentEntity paymentEntity = PaymentMapper.toPaymentEntity(calculatePaymentsResponse);
                paymentEntity.setLoanInfoEntity(loanInfoEntity);
                paymentEntityList.add(paymentEntity);

                paymentDate = Util.addWeek(paymentDate);
            }

            saveAllPaymentEntity(paymentEntityList);

            return ResponseEntity.status(HttpStatus.OK).body(responseList);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    public LoanInfoEntity saveLoanInfoEntity(CalculatePaymentsRequest request) {
        LoanInfoEntity loanInfoEntity = LoanInfoMapper.toLoanInfoEntity(request);
        return iLoanDao.save(loanInfoEntity);
    }

    public void saveAllPaymentEntity(List<PaymentEntity> paymentEntityList){
        iPaymentDao.saveAll(paymentEntityList);
    }

    public boolean invalidRequest(CalculatePaymentsRequest request){
        return (request.getTerms() <= 0 || request.getAmount() <= 0 || request.getRate() <= 0 || request.getRate() > 100 );
    }
}
