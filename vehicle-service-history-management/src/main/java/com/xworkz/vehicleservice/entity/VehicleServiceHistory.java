package com.xworkz.vehicleservice.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity

@Table(name = "vehicle_service_history")
@NamedQuery(name = "findAllDetails", query = "SELECT a from VehicleServiceHistory a")
public class VehicleServiceHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private int id;

    @Column(name = "registration_number")
    private String registrationNumber;

    @Column(name = "service_type")
    private String serviceType;

    @Column(name = "service_cost")
    private double serviceCost;

    @Column(name = "service_data")
    private String serviceData;

    @Column(name = "service_center")
    private String serviceCenter;
}
