package com.xworkz.warehouseinventory.service;

import com.xworkz.warehouseinventory.entity.InventoryEntity;
import com.xworkz.warehouseinventory.repository.Inventory;
import com.xworkz.warehouseinventory.repository.InventoryImpl;

import java.util.Collections;
import java.util.List;

public class InventoryServiceImpl implements InventoryService{

    Inventory repository = new InventoryImpl();

    @Override
    public boolean validateAndSaveInventoryInfo(InventoryEntity entity) {
        System.out.println("Invoking validation");
        boolean saveValid = false;

        if (entity != null) {
            saveValid = repository.saveInventoryInfo(entity);
        } else {
            saveValid = false;
        }
        return saveValid;
    }

    @Override
    public boolean validateAndUpdateItemNameCategoryquantityById(String itemName, String category, int quantity, int id) {
        System.out.println("Invoking validation");
        boolean updateValid = false;

        if (itemName!=null && !itemName.isEmpty() && category!=null && !category.isEmpty() && quantity>0 && id>0) {
            updateValid = repository.updateItemNameCategoryquantityById(itemName, category, quantity, id);
        } else {
            updateValid = false;
        }
        return updateValid;
    }

    @Override
    public String validateAndUpdateAllDetailsById(InventoryEntity entity) {
        System.out.println("Invoking validation");
        String isValid = null;

        if (entity != null) {
            isValid = repository.updateAllDetailsById(entity);
        } else {
            System.out.println("Validation failed");
        }
        return isValid;
    }

    @Override
    public boolean validateAndDeleteById(int id) {
        System.out.println("Invoking validation");
        boolean validDelete = false;

        if (id>0) {
            validDelete = repository.deleteById(id);
        } else {
            validDelete = false;
        }
        return validDelete;
    }

    @Override
    public InventoryEntity validAndFindInventoryById(int id) {
        System.out.println("Invoking validation");
        InventoryEntity validDel = null;

        if (id > 0) {
            validDel = repository.findInventoryById(id);
        }
        return validDel;
    }

    @Override
    public List<InventoryEntity> validateAndFindAllInventoryDetails() {
        System.out.println("Invoking validation");

        List<InventoryEntity> list = repository.findAllInventoryDetails();
        if (list!=null && !list.isEmpty()) {
            System.out.println("Inventory found: " + list.size());
        }
        return list;
    }
}
