package com.xworkz.mobile.service;

import com.xworkz.mobile.entity.MobileEntity;

import java.util.List;

public interface MobileService {
    String validateAndSave(MobileEntity entity);
    boolean validateAndUpdatePriceQuantityMfdById(double price, int quantity, String mfd, int id);
    MobileEntity validateAllDetailsById(MobileEntity entity);
    boolean validateDeleteById(int id);
    MobileEntity ValidateAndFindMobileEntityById(int id);
    List<MobileEntity> validateAndFindAllMobileDetails();
    List<MobileEntity> validateAndGetMobileEntityByMfdAndPriceAndQuantity(String mfd, double price, int quantity);
    List<MobileEntity> validateAndGetMobileEntityByBrandAndPrice(String brand, double price);




}
