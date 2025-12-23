package com.xworkz.onlinepayment.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity

@Table(name = "payment_transaction")
@NamedQuery(name = "findAllDetails" , query =  "SELECT x from PaymentEntity x")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private int id;

    @Column(name = "user_reference")
    private String userReference;

    @Column(name = "amount")
    private double amount;

    @Column(name = "payment_mode")
    private String paymentMode;

    @Column(name = "transaction_status")
    private String transactionStatus;

    @Column(name = "transaction_time")
    private String transactionTime;
}
