package com.xworkz.vehicleservice.runner;

import com.xworkz.vehicleservice.entity.VehicleServiceHistory;
import com.xworkz.vehicleservice.service.VehicleService;
import com.xworkz.vehicleservice.service.VehicleServiceImpl;

import java.util.List;

public class VehicleServiceRunner {

    public static void main(String[] args) {

//        System.out.println("Inserting data into data base...............");
        VehicleServiceHistory obj = new VehicleServiceHistory();

//        obj.setRegistrationNumber("KA05IJ7890");
//        obj.setServiceType("Wheel Alignment");
//        obj.setServiceCost(1800);
//        obj.setServiceData("2025-01-18");
//        obj.setServiceCenter("GoMechanic");

        VehicleService service = new VehicleServiceImpl();

//        VehicleServiceHistory saving = service.validateAndSaveVehicleInfo(obj);
//        if (obj != null) {
//            System.out.println("Saved Successfully");
//        } else {
//            System.out.println("Saving failed");
//        }

//        System.out.println("Update by Id................");
//        boolean isupdate = service.validateAndUpdateRegNumbServiceTypeCostById("DD06UU5623", "Fuel Tank service", 2100, 2);
//        if (isupdate) {
//            System.out.println("update success");
//        } else {
//            System.out.println("update failed");
//        }

//        obj.setId(5);
//        obj.setRegistrationNumber("NA05IJ7090");
//        obj.setServiceType("Brake Replacement");
//        obj.setServiceCost(7800);
//        obj.setServiceData("2025-01-25");
//        obj.setServiceCenter("Bajaj");
//
//        VehicleServiceHistory validateAll = service.validateAndUpdateAllDetailsById(obj);
//        System.out.println(validateAll);

//        boolean del = service.validateAndDeleteById(3);
//        if (del) {
//            System.out.println("Deleted successfully");
//        } else {
//            System.out.println("Delete failed");
//        }

//        VehicleServiceHistory fetching = service.validateAndFetchDetailsById(2);
//        System.out.println(fetching);

//        List<VehicleServiceHistory> vehicleList = service.validateAndFindAllVehicleDetails();
//        System.out.println(vehicleList);

//        List<VehicleServiceHistory> vehicle1 = service.validateAndGetServiceTypeServiceCostServiceCenter("Oil Change", 2500, "Bosch Service Center");
//        System.out.println(vehicle1);

        List<VehicleServiceHistory> veh = service.validateAndGetServiceTypeAndServiceCost("Engine Check", 6500);
        System.out.println(veh);
    }
}
