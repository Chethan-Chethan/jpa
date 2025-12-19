package com.xworkz.inventory.runner;

import com.xworkz.inventory.entity.InventoryEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InventoryUpdate {
    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;
        try {
            emf = Persistence.createEntityManagerFactory("inventory");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            InventoryEntity entity = em.find(InventoryEntity.class, 2);
            System.out.println(entity);
            entity.setCurrentStock(22);
            InventoryEntity updateEntity = em.merge(entity);
            System.out.println(updateEntity);
            et.commit();

        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }
}