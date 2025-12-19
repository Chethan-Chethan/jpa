package com.xworkz.parking.runner;

import com.xworkz.parking.entity.ParkingEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ParkingUpdate {
    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("smart_parking");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            ParkingEntity entity = em.find(ParkingEntity.class, 2);
            System.out.println(entity);
            entity.setVehicleType("Auto");
            ParkingEntity updateEntity = em.merge(entity);
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
                em.close();
            }
        }
    }
}