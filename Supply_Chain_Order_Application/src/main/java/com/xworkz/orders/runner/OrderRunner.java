package com.xworkz.orders.runner;

import com.xworkz.orders.entity.OrderEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class OrderRunner {

    public static void main(String[] args) {

        OrderEntity entity = new OrderEntity();
        entity.setOrderNumber("PO-7782");
        entity.setSupplierName("Tata Steel");
        entity.setStatus("SHIPPED");
        entity.setOrderValue(550000.00);

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;
        try {
            emf = Persistence.createEntityManagerFactory("supply_chain");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(entity);
            System.out.println("Entity inserted successfully");
            et.commit();
            et.rollback();
        } catch (Exception e) {
            e.printStackTrace();
//            et.rollback();
        } finally {
            if (emf != null) {
                emf.close();
            }
            if (em != null) {
                em.close();
            }
        }

    }
}
