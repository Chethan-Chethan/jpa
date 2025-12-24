package com.xworkz.vehicleservice.repository;

import com.xworkz.vehicleservice.entity.VehicleServiceHistory;

import java.util.List;

public interface VehicleServiceRepository {

    VehicleServiceHistory saveVehicleInfo(VehicleServiceHistory entity);
    boolean updateRegNumbServiceTypeCostById(String registrationNumber, String serviceType, double serviceCost, int id);
    VehicleServiceHistory updateAllDetailsById(VehicleServiceHistory entity);
    boolean deleteById(int id);
    VehicleServiceHistory fetchDetailsById(int id);
    List<VehicleServiceHistory> findAllVehicleDetails();
    List<VehicleServiceHistory> getServiceTypeServiceCostServiceCenter(String serviceType, double serviceCost, String serviceCenter);
    List<VehicleServiceHistory> getServiceTypeAndServiceCost(String serviceType, double serviceCost);
}
