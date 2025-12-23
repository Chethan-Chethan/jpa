package com.xworkz.vehicleservice.service;

import com.xworkz.vehicleservice.entity.VehicleServiceHistory;

import java.util.List;

public interface VehicleService {

    VehicleServiceHistory validateAndSaveVehicleInfo(VehicleServiceHistory entity);
    boolean validateAndUpdateRegNumbServiceTypeCostById(String registrationNumber, String serviceType, double serviceCost, int id);
    VehicleServiceHistory validateAndUpdateAllDetailsById(VehicleServiceHistory entity);
    boolean validateAndDeleteById(int id);
    VehicleServiceHistory validateAndFetchDetailsById(int id);
    List<VehicleServiceHistory> validateAndFindAllVehicleDetails();
}
