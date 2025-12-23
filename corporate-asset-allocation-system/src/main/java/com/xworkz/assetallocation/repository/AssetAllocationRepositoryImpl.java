package com.xworkz.assetallocation.repository;

import com.xworkz.assetallocation.entity.AssetAllocationEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;


public class AssetAllocationRepositoryImpl implements AssetAllocationRepository{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("asset");

    @Override
    public String assetAllocationInfo(AssetAllocationEntity entity) {
        System.out.println("Asset Info");
        String assetinfo = null;

        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            System.out.println("Started");
            em.persist(entity);
            System.out.println("Commited");
            et.commit();
            assetinfo = "Saved successfully";
        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return assetinfo;
    }

    @Override
    public boolean updateAssetTypeAllocatedToById(String assetType, String allocationTo, int id) {
        System.out.println("Update using Id");
        boolean update = false;

        EntityManager em = null;
        EntityTransaction et = null;
        try {
            em = this.emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            AssetAllocationEntity insert = em.find(AssetAllocationEntity.class, id);
            insert.setAssetType(assetType);
            insert.setAllocationTo(allocationTo);
            em.merge(insert);
            et.commit();
            update = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return update;
    }

    @Override
    public AssetAllocationEntity updateAllDetailsById(AssetAllocationEntity entity) {
        System.out.println("Updating all details");
        AssetAllocationEntity updateAll = null;

        EntityManager em = null;
        EntityTransaction et = null;
        try {
            em = this.emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            AssetAllocationEntity updated = em.find(AssetAllocationEntity.class, entity.getId());
            updated.setAssetName(entity.getAssetName());
            updated.setAssetType(entity.getAssetType());
            updated.setAllocationTo(entity.getAllocationTo());
            updated.setAllocationDate(entity.getAllocationDate());
            updated.setAssetStatus(entity.getAssetStatus());
            updateAll = em.merge(updated);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return updateAll;
    }

    @Override
    public boolean deleteById(int id) {
        System.out.println("deleting");
        boolean delete = false;

        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = this.emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            AssetAllocationEntity del = em.find(AssetAllocationEntity.class, id);
            em.remove(del);
            et.commit();
            delete = true;
        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return delete;
    }

    @Override
    public AssetAllocationEntity findAssetEntityById(int id) {
        System.out.println("fetching from data base");
        AssetAllocationEntity fetch = null;

        EntityManager em = null;
        try {
            em = this.emf.createEntityManager();
            fetch = em.find(AssetAllocationEntity.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return fetch;
    }

    @Override
    public List<AssetAllocationEntity> findAllAssetDetails() {
        System.out.println("Fetching all details in the table");
        List<AssetAllocationEntity> assetEntity = null;

        EntityManager em = null;

        try {
            em = this.emf.createEntityManager();
            Query query = em.createNamedQuery("findAllDetails");
            assetEntity = query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return assetEntity;
    }
}
