package com.xworkz.iotdevice.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
@Setter
@Getter
@Entity
@ToString

@Table(name = "iot_device")
public class DeviceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "serial_numb")
    private String serialNumber;

    @Column(name = "model")
    private String model;

    @Column(name = "location")
    private String location;

    @Column(name = "is_active")
    private boolean isActive;

}
