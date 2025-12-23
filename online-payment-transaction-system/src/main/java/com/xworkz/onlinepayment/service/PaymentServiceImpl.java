package com.xworkz.onlinepayment.service;

import com.xworkz.onlinepayment.entity.PaymentEntity;
import com.xworkz.onlinepayment.repository.PaymentRepository;
import com.xworkz.onlinepayment.repository.PaymentRepositoryImpl;

import java.util.Collections;
import java.util.List;

public class PaymentServiceImpl implements PaymentService{

    PaymentRepository repository = new PaymentRepositoryImpl();
    @Override
    public PaymentEntity updateAndSavePaymentInfo(PaymentEntity entity) {
        System.out.println("Invoking validation");
        PaymentEntity insert = null;

        if (entity != null) {
            insert = repository.savePaymentInfo(entity);
        }
        return insert;
    }

    @Override
    public boolean validAndUpdateAmountPaymentModeTransactionStatusById(double amount, String paymentMode, String transactionStatus, int id) {
        System.out.println("Invoking validation update");
        boolean update = false;

        if (amount>0 && paymentMode!=null && !paymentMode.isEmpty() && transactionStatus!=null && !transactionStatus.isEmpty() && id>0) {
            update = repository.updateAmountPaymentModeTransactionStatusById(amount, paymentMode, transactionStatus,id);
        } else {
            update = false;
        }
        return update;
    }

    @Override
    public PaymentEntity validAndUpdateAllDetailsById(PaymentEntity entity) {
        System.out.println("Invoking update valid");
        PaymentEntity isUpdate = null;

        if (entity != null) {
            isUpdate = repository.updateAllDetailsById(entity);
        } else {
            isUpdate = null;
        }
        return isUpdate;
    }

    @Override
    public boolean ValidateAndDeleteById(int id) {
        System.out.println("Invoking validation");
        boolean isUpdate = false;

        if (id>0) {
            isUpdate = repository.deleteById(id);
        } else {
            isUpdate = false;
        }
        return isUpdate;
    }

    @Override
    public PaymentEntity validateAndFindPaymentEntityById(int id) {
        System.out.println("Invoking fetch");
        PaymentEntity fteched = null;

        if (id>0) {
            fteched = repository.findPaymentEntityById(id);
        }
        return fteched;
    }

    @Override
    public List<PaymentEntity> validateAndFindAllPaymentDetails() {
        System.out.println("Invoking validation");

        List<PaymentEntity> list = repository.findAllPaymentDetails();
        if (list!=null && !list.isEmpty()) {
            System.out.println("Payment Entity found: " + list.size());
        } else {
            list = null;
        }
        return list;
    }
}
