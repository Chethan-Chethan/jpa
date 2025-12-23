package com.xworkz.onlinepayment.repository;

import com.xworkz.onlinepayment.entity.PaymentEntity;

import java.util.List;

public interface PaymentRepository {
    PaymentEntity savePaymentInfo(PaymentEntity entity);
    boolean updateAmountPaymentModeTransactionStatusById(double amount, String paymentMode, String transactionStatus, int id);
    PaymentEntity updateAllDetailsById(PaymentEntity entity);
    boolean deleteById(int id);
    PaymentEntity findPaymentEntityById(int id);
    List<PaymentEntity> findAllPaymentDetails();
}
