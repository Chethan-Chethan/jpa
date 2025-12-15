package com.xworkz.subscription.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString

@Table(name = "subscription")
public class SubscriptionEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "plan_name")
    private String planName;

    @Column(name = "monthly_fee")
    private double monthlyFee;

    @Column(name = "active")
    private boolean active;
}
