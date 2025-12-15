package com.xworkz.crypto.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity

@Table(name = "crypto_portfolio")
public class CryptoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "asset_name")
    private String assetName;

    @Column(name = "buy_price")
    private double buyPrice;

    @Column(name = "quantity")
    private double quantity;

    @Column(name = "exchange")
    private String exchange;
}
