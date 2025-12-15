package com.xworkz.parking.runner;

import com.xworkz.parking.entity.ParkingEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ParkingRunner {

    public static void main(String[] args) {
        ParkingEntity entity = new ParkingEntity();
        entity.setSlotCode("A1");
        entity.setReserved(false);
        entity.setVehicleType("CAR");

        ParkingEntity entity1 = new ParkingEntity();
        entity1.setSlotCode("A2");
        entity1.setReserved(true);
        entity1.setVehicleType("BIKE");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;
        try {
            emf = Persistence.createEntityManagerFactory("smart_parking");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(entity);
            em.persist(entity1);
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
            System.out.println("Costly resources successfully closed");
        }
    }
}