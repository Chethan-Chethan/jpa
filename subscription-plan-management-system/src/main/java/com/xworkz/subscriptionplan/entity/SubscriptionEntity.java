package com.xworkz.subscriptionplan.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity

@Table(name = "subscription_plan")
@NamedQuery(name = "findAllSubscriptionEntities", query = "SELECT n from SubscriptionEntity n")
public class SubscriptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plan_id")
    private int planId;

    @Column(name = "plan_name")
    private String planName;

    @Column(name = "price")
    private double price;

    @Column(name = "duration_months")
    private int durationMonths;

    @Column(name = "max_users")
    private int maxUsers;

    @Column(name = "is_active")
    private boolean isActive;
}
