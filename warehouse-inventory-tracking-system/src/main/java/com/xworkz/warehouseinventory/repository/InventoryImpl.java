package com.xworkz.warehouseinventory.repository;

import com.xworkz.warehouseinventory.entity.InventoryEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class InventoryImpl implements Inventory{

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("warehouse");

    @Override
    public boolean saveInventoryInfo(InventoryEntity entity) {
        System.out.println("Inserting data");
        boolean insert = false;


        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = this.emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(entity);
            et.commit();
            insert = true;
        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();
            insert = false;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return insert;
    }

    @Override
    public boolean updateItemNameCategoryquantityById(String itemName, String category, int quantity, int id) {
        System.out.println("Invoking update");
        boolean update = false;

        EntityManager em = null;
        EntityTransaction et = null;
        try {
            em = this.emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            InventoryEntity sru = em.find(InventoryEntity.class, id);
            if (sru != null) {
                sru.setItemName(itemName);
                sru.setCategory(category);
                sru.setQuantity(quantity);
                em.merge(sru);
                et.commit();
                update = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();
            update = false;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return update;
    }

    @Override
    public String updateAllDetailsById(InventoryEntity entity) {
        System.out.println("Update details by Id");
        String isUpdate = null;

        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = this.emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            InventoryEntity entityUpdate = em.find(InventoryEntity.class, 2);
            entityUpdate.setItemName(entity.getItemName());
            entityUpdate.setCategory(entity.getCategory());
            entityUpdate.setQuantity(entity.getQuantity());
            entityUpdate.setWarehouseLocation(entity.getWarehouseLocation());
            entityUpdate.setLastUpdate(entity.getLastUpdate());
            et.commit();
            isUpdate = "successfully done";
            System.out.println("OLD: " + entityUpdate.getItemName());
            System.out.println("NEW: " + entity.getItemName());

        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return isUpdate;
    }

    @Override
    public boolean deleteById(int id) {
        System.out.println("deleting using id");
        boolean isdelete = false;

        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            InventoryEntity entity = em.find(InventoryEntity.class, id);
            em.remove(entity);
            et.commit();
            isdelete = true;
        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return isdelete;
    }

    @Override
    public InventoryEntity findInventoryById(int id) {
        System.out.println("Fetching Invoked");
        InventoryEntity fetch = null;

        EntityManager em = null;
        EntityTransaction et = null;


        try {
            em = this.emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            fetch = em.find(InventoryEntity.class, id);
            et.commit();

        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return fetch;
    }

    @Override
    public List<InventoryEntity> findAllInventoryDetails() {
        System.out.println("FInd all details of Inventory");
        List<InventoryEntity> inventoryEntities = null;

        EntityManager em = null;

        try {
            em = this.emf.createEntityManager();
            Query query = em.createNamedQuery("findAllDetails");
            inventoryEntities = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em !=null) {
                em.close();
            }
        }
        return inventoryEntities;
    }
}
