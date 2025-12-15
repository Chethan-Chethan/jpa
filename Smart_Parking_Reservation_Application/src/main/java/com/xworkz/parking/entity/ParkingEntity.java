package com.xworkz.parking.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity

@Table(name = "parking_slot")
public class ParkingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "slot_code")
    private String slotCode;

    @Column(name = "reserved")
    private boolean reserved;

    @Column(name = "vehicle_type")
    private String vehicleType;
}
