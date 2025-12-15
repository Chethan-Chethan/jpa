package com.xworkz.orders.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString


@Table(name = "supply_order")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "order_number")
    private String orderNumber;

    @Column(name = "supplier_name")
    private String supplierName;

    @Column(name = "status")
    private String status;

    @Column(name = "order_value")
    private double orderValue;
}
