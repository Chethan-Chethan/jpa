package com.xworkz.assetallocation.service;

import com.xworkz.assetallocation.entity.AssetAllocationEntity;
import com.xworkz.assetallocation.repository.AssetAllocationRepository;
import com.xworkz.assetallocation.repository.AssetAllocationRepositoryImpl;

import java.util.Collections;
import java.util.List;

public class AssetAllocationServiceImpl implements AssetAllocationService{

    AssetAllocationRepository repository = new AssetAllocationRepositoryImpl();

    @Override
    public String validateAndUpdateAssetAllocationInfo(AssetAllocationEntity entity) {
        System.out.println("Invoking validation");
        String saveValid = null;

        if (entity != null) {
            saveValid = repository.assetAllocationInfo(entity);
        } else {
            saveValid = "Saving failed";
        }
        return saveValid;
    }

    @Override
    public boolean validateAndUpdateAssetTypeAllocatedToById(String assetType, String allocationTo, int id) {
        System.out.println("Invoking update Validation");
        boolean validUpdate = false;

        if (assetType!= null && !assetType.isEmpty() && allocationTo!=null && !allocationTo.isEmpty() && id>0) {
            validUpdate = repository.updateAssetTypeAllocatedToById(assetType, allocationTo, id);
        } else {
            validUpdate = false;
        }
        return validUpdate;
    }

    @Override
    public AssetAllocationEntity validateAndUpdateAllDetailsById(AssetAllocationEntity entity) {
        System.out.println("Invoking Validation");
        AssetAllocationEntity updateAllValid = null;

        if (entity != null) {
            updateAllValid = repository.updateAllDetailsById(entity);
        } else {
            updateAllValid = null;
        }
        return updateAllValid;
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
    public AssetAllocationEntity validateAndFindAssetEntityById(int id) {
        System.out.println("Invoking validation");
        AssetAllocationEntity validFetch = null;

        if (id>0) {
            validFetch = repository.findAssetEntityById(id);
        } else {
            validFetch = null;
        }
        return validFetch;
    }

    @Override
    public List<AssetAllocationEntity> validateAndFindAllAssetDetails() {
        System.out.println("Invoking validation");
        List<AssetAllocationEntity> list = repository.findAllAssetDetails();
        if (list!=null && !list.isEmpty()) {
            System.out.println("asset details found: " + list.size());
        }
        return list;
    }

    @Override
    public List<AssetAllocationEntity> validateAndGetAssetNameAssetTypeAssetStatus(String assetName, String assetType, String assetStatus) {
        System.out.println("Invoking validation");
        List<AssetAllocationEntity> asset1 = null;

        if (assetName!=null && !assetName.isEmpty() && assetType!=null && !assetType.isEmpty() && assetStatus!=null && !assetStatus.isEmpty()) {
           asset1 =  repository.getAssetNameAssetTypeAssetStatus(assetName, assetType, assetStatus);
        } else {
            asset1 = null;
        }
        return asset1;
    }

    @Override
    public List<AssetAllocationEntity> validateAndGetAssetTypeAsstStatus(String assetType, String assetStatus) {
        System.out.println("Invoking validation");
        List<AssetAllocationEntity> asset2 = null;

        if (assetType!=null && !assetType.isEmpty() && assetStatus!=null && !assetStatus.isEmpty()) {
            asset2 = repository.getAssetTypeAsstStatus(assetType, assetStatus);
        } else {
            asset2 = null;
        }
        return asset2;
    }
}
