package com.xworkz.warehouseinventory.repository;

import com.xworkz.warehouseinventory.entity.InventoryEntity;

import java.util.List;

public interface Inventory {

    boolean saveInventoryInfo(InventoryEntity entity);
    boolean updateItemNameCategoryquantityById(String itemName, String category, int quantity, int id);
    String updateAllDetailsById(InventoryEntity entity);
    boolean deleteById(int id);
    InventoryEntity findInventoryById(int id);
    List<InventoryEntity> findAllInventoryDetails();
    List<InventoryEntity> getItemNameCategoryQuantity(String itemName, String category, int quantity);
    List<InventoryEntity> getCategoryAndQuantity(String category, int quantity);
}
