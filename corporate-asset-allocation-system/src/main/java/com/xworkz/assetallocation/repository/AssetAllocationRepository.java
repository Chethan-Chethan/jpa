package com.xworkz.assetallocation.repository;

import com.xworkz.assetallocation.entity.AssetAllocationEntity;

import java.util.List;

public interface AssetAllocationRepository {

    String assetAllocationInfo(AssetAllocationEntity entity);
    boolean updateAssetTypeAllocatedToById(String assetType, String allocationTo, int id);
    AssetAllocationEntity updateAllDetailsById(AssetAllocationEntity entity);
    boolean deleteById(int id);
    AssetAllocationEntity findAssetEntityById(int id);
    List<AssetAllocationEntity> findAllAssetDetails();
    List<AssetAllocationEntity> getAssetNameAssetTypeAssetStatus(String assetName, String assetType, String assetStatus);
    List<AssetAllocationEntity> getAssetTypeAsstStatus(String assetType, String assetStatus);
}
