package com.xworkz.vehicleservice.service;

import com.xworkz.vehicleservice.entity.VehicleServiceHistory;
import com.xworkz.vehicleservice.repository.VehicleServiceRepository;
import com.xworkz.vehicleservice.repository.VehicleServiceRepositoryImpl;

import java.util.Collections;
import java.util.List;

public class VehicleServiceImpl implements VehicleService{

    VehicleServiceRepository repository = new VehicleServiceRepositoryImpl();

    @Override
    public VehicleServiceHistory validateAndSaveVehicleInfo(VehicleServiceHistory entity) {
        System.out.println("Invoking validation");
        VehicleServiceHistory saveValid = null;

        if (entity != null) {
            saveValid = repository.saveVehicleInfo(entity);
        } else {
            saveValid = null;
        }
        return saveValid;
    }

    @Override
    public boolean validateAndUpdateRegNumbServiceTypeCostById(String registrationNumber, String serviceType, double serviceCost, int id) {
        System.out.println("Invoking validation");
        boolean validUpdate = false;

        if (registrationNumber!= null && !registrationNumber.isEmpty() && serviceType!=null && !serviceType.isEmpty() && serviceCost>0 && id>0) {
            validUpdate = repository.updateRegNumbServiceTypeCostById(registrationNumber, serviceType, serviceCost, id);
        } else {
            validUpdate = false;
        }
        return validUpdate;
    }

    @Override
    public VehicleServiceHistory validateAndUpdateAllDetailsById(VehicleServiceHistory entity) {
        System.out.println("Validate and update");
        VehicleServiceHistory validUpdate = null;

        if (entity != null) {
            validUpdate = repository.updateAllDetailsById(entity);
        } else {
            System.out.println("Validation failed");
        }
        return validUpdate;
    }

    @Override
    public boolean validateAndDeleteById(int id) {
        System.out.println("Invoking Delete Validation");
        boolean validDelete = false;

        if (id>0) {
            validDelete = repository.deleteById(id);
        } else {
            validDelete = false;
        }
        return validDelete;
    }

    @Override
    public VehicleServiceHistory validateAndFetchDetailsById(int id) {
        System.out.println("Invoking Validation");
        VehicleServiceHistory validFetch = null;

        if (id>0) {
            validFetch = repository.fetchDetailsById(id);
        } else {
            validFetch = null;
        }
        return validFetch;
    }

    @Override
    public List<VehicleServiceHistory> validateAndFindAllVehicleDetails() {
        System.out.println("Invoking validation");

        List<VehicleServiceHistory> list = repository.findAllVehicleDetails();
        if (list!=null && !list.isEmpty()) {
            System.out.println("Vehicle entity found: " + list.size());
        }
        return list;
    }
}
