package com.xworkz.onlinepayment.runner;

import com.xworkz.onlinepayment.entity.PaymentEntity;
import com.xworkz.onlinepayment.service.PaymentService;
import com.xworkz.onlinepayment.service.PaymentServiceImpl;

import java.util.List;

public class PaymentRunner {

    public static void main(String[] args) {

        PaymentEntity payment = new PaymentEntity();
//        payment.setUserReference("USR1004");
//        payment.setAmount(899);
//        payment.setPaymentMode("Debit Card");
//        payment.setTransactionStatus("Pending");
//        payment.setTransactionTime("012:45:40");

        PaymentService service = new PaymentServiceImpl();
//        PaymentEntity inserted = service.updateAndSavePaymentInfo(payment);
//        System.out.println(inserted);
//
//        boolean isupdate = service.validAndUpdateAmountPaymentModeTransactionStatusById(1200, "UPI", "Failed", 2);
//        if (isupdate) {
//            System.out.println("Update successful");
//        } else {
//            System.out.println("Update failed");
//        }

//        payment.setUserReference("USR1004");
//        payment.setAmount(3000);
//        payment.setPaymentMode("Credit card");
//        payment.setTransactionStatus("Pending");
//        payment.setTransactionTime("13:40:20");

//        PaymentEntity updated = service.validAndUpdateAllDetailsById(payment);
//        System.out.println(updated);

//        boolean deleted = service.ValidateAndDeleteById(1);
//        if (deleted) {
//            System.out.println("Deleted successfully");
//        } else {
//            System.out.println("Delete failed");
//        }

//        PaymentEntity isFetched = service.validateAndFindPaymentEntityById(2);
//        System.out.println(isFetched);

//        List<PaymentEntity> paymentList = service.validateAndFindAllPaymentDetails();
//        System.out.println(paymentList);

//        List<PaymentEntity> fix = service.validateAndGetPaymentEntityByAmountPaymentModeTransactionStatus(1999, "Net Banking", "Failed");
//        System.out.println(fix);

        List<PaymentEntity> paymentEntityList = service.validateAndGetAmountAndTransactionStatus(899, "pending");
        System.out.println(paymentEntityList);
    }
}
