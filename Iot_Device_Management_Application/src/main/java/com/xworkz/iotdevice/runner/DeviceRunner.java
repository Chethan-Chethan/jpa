package com.xworkz.iotdevice.runner;

import com.xworkz.iotdevice.entity.DeviceEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeviceRunner {
    public static void main(String[] args) {
        DeviceEntity entity = new DeviceEntity();
//        entity.setId(100);
        entity.setSerialNumber("SN12345");
        entity.setModel("TempSensor");
        entity.setLocation("Warehouse-3");
        entity.setActive(true);

        DeviceEntity entity1 = new DeviceEntity();
        entity1.setSerialNumber("SN23456");
        entity1.setModel("ActualSensor");
        entity1.setLocation("Warehouse-5");
        entity1.setActive(false);

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;
        try {
            emf = Persistence.createEntityManagerFactory("device");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(entity);
            System.out.println("entity inserted");
            em.persist(entity1);
            System.out.println("entity1 data inserted");
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
        }
        System.out.println(entity1);
    }
}