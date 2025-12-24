package com.xworkz.warehouseinventory.service;

import com.xworkz.warehouseinventory.entity.InventoryEntity;

import java.util.List;

public interface InventoryService {

    boolean validateAndSaveInventoryInfo(InventoryEntity entity);
    boolean validateAndUpdateItemNameCategoryquantityById(String itemName, String category, int quantity, int id);
    String validateAndUpdateAllDetailsById(InventoryEntity entity);
    boolean validateAndDeleteById(int id);
    InventoryEntity validAndFindInventoryById(int id);
    List<InventoryEntity> validateAndFindAllInventoryDetails();
    List<InventoryEntity> validateAndGetItemNameCategoryQuantity(String itemName, String category, int quantity);
    List<InventoryEntity> validateAndGetCategoryAndQuantity(String category, int quantity);


}
