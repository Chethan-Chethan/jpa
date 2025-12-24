package com.xworkz.assetallocation.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity


@Table(name = "asset_allocation")
@NamedQuery(name = "findAllDetails", query = "SELECT c from AssetAllocationEntity c")
@NamedQuery(name = "findAssetNameAssetTypeAssetStatus",
        query = "select x from AssetAllocationEntity x where x.assetName=:assetName and " +
                "x.assetType=:assetType and x.assetStatus=:assetStatus")
@NamedQuery(name = "findAssetTypeAsstStatus",
        query = "select x from AssetAllocationEntity x where x.assetType=: assetType and " +
                "x.assetStatus=: assetStatus")
public class AssetAllocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asset_id")
    private int id;

    @Column(name = "asset_name")
    private String assetName;

    @Column(name = "asset_type")
    private String assetType;

    @Column(name = "allocated_to")
    private String allocationTo;

    @Column(name = "allocation_date")
    private String allocationDate;

    @Column(name = "asset_status")
    private String assetStatus;
}
