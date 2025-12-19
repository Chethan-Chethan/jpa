package com.xworkz.iotdevice.runner;

import com.xworkz.iotdevice.entity.DeviceEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeviceUpdate {

    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("device");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            DeviceEntity entity = em.find(DeviceEntity.class, 2);
            System.out.println("old data: " + entity);
            entity.setLocation("wearehouse-2");
            DeviceEntity updateEntity = em.merge(entity);
            System.out.println("updated data: " + updateEntity);
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