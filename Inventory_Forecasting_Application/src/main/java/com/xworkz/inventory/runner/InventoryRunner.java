package com.xworkz.inventory.runner;

import com.xworkz.inventory.entity.InventoryEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InventoryRunner {

    public static void main(String[] args) {

        InventoryEntity inventory = new InventoryEntity();
        inventory.setProductName("Industrial Motor");
        inventory.setCurrentStock(120);
        inventory.setReorderLevel(30);

        InventoryEntity inventory1 = new InventoryEntity();
        inventory1.setProductName("Hydraulic Pump");
        inventory1.setCurrentStock(45);
        inventory1.setReorderLevel(15);

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("inventory");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(inventory);
            em.persist(inventory1);
            System.out.println("Data inserted successfully");
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();
        } finally {
            if (emf != null) {
                emf.close();
            }
            if (em != null) {
                em.close();
            }
            System.out.println("Costly resources closed");
        }
    }
}