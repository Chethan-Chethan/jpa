package com.xworkz.assetallocation.service;

import com.xworkz.assetallocation.entity.AssetAllocationEntity;

import java.util.List;

public interface AssetAllocationService {

    String validateAndUpdateAssetAllocationInfo(AssetAllocationEntity entity);
    boolean validateAndUpdateAssetTypeAllocatedToById(String assetType, String allocationTo, int id);
    AssetAllocationEntity validateAndUpdateAllDetailsById(AssetAllocationEntity entity);
    boolean validateAndDeleteById(int id);
    AssetAllocationEntity validateAndFindAssetEntityById(int id);
    List<AssetAllocationEntity> validateAndFindAllAssetDetails();
}
