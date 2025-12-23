package com.xworkz.onlinepayment.service;

import com.xworkz.onlinepayment.entity.PaymentEntity;

import java.util.List;

public interface PaymentService {
    PaymentEntity updateAndSavePaymentInfo(PaymentEntity entity);
    boolean validAndUpdateAmountPaymentModeTransactionStatusById(double amount, String paymentMode, String transactionStatus, int id);
    PaymentEntity validAndUpdateAllDetailsById(PaymentEntity entity);
    boolean ValidateAndDeleteById(int id);
    PaymentEntity validateAndFindPaymentEntityById(int id);
    List<PaymentEntity> validateAndFindAllPaymentDetails();
}
