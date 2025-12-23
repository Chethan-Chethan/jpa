package com.xworkz.assetallocation.runner;

import com.xworkz.assetallocation.entity.AssetAllocationEntity;
import com.xworkz.assetallocation.service.AssetAllocationService;
import com.xworkz.assetallocation.service.AssetAllocationServiceImpl;

import java.util.List;

public class AssetAllocationRunner {

    public static void main(String[] args) {

        AssetAllocationEntity obj = new AssetAllocationEntity();
//        obj.setAssetName("Network Switch");
//        obj.setAssetType("Networking");
//        obj.setAllocationTo("IT_INFRA");
//        obj.setAllocationDate("2025-01-12");
//        obj.setAssetStatus("MAINTENANCE");

        AssetAllocationService service = new AssetAllocationServiceImpl();
//        String saved = service.validateAndUpdateAssetAllocationInfo(obj);
//        System.out.println(saved);

//        boolean updated = service.validateAndUpdateAssetTypeAllocatedToById("Laptop_1", "EMP1025", 1);
//        if (updated) {
//            System.out.println("update Successful");
//        } else {
//            System.out.println("update failed");
//        }
//
//        obj.setId(1);
//        obj.setAssetName("Dell Latitude 5430");
//        obj.setAssetType("Laptop-2");
//        obj.setAllocationTo("BBB1023");
//        obj.setAllocationDate("2025-01-25");
//        obj.setAssetStatus("PENDING");
//
//        AssetAllocationEntity fullUpdate = service.validateAndUpdateAllDetailsById(obj);
//        System.out.println(fullUpdate);

//        boolean deleted = service.validateAndDeleteById(2);
//        if (deleted) {
//            System.out.println("Delete successful");
//        } else {
//            System.out.println("Delete unsuccessful");
//        }

//        AssetAllocationEntity fetched = service.validateAndFindAssetEntityById(4);
//        System.out.println(fetched);

        List<AssetAllocationEntity> assetList = service.validateAndFindAllAssetDetails();
        System.out.println(assetList);
    }
}
