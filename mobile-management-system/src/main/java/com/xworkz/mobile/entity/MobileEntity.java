package com.xworkz.mobile.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity

@Table(name = "mobile_info")
@NamedQuery(name = "findAllMobileEntities", query = "SELECT m from MobileEntity m")
@NamedQuery(name = "findMobileEntityByMfdAndPriceAndQuantity", query = "SELECT a from MobileEntity a WHERE a.mfd=:mfdDate and a.price=:price and a.quantity=:quantity")
@NamedQuery(name = "findMobileEntityByBrandAndPrice", query = "select x from MobileEntity x where x.brand=:brand and x.price=:price")
public class MobileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mobile_id")
    private int mobileId;

    @Column(name = "name")
    private String name;

    @Column(name = "brand")
    private String brand;

    @Column(name = "price")
    private double price;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "mfd")
    private String mfd;
}
