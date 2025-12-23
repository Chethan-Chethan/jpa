package com.xworkz.vehicleservice.repository;

import com.xworkz.vehicleservice.entity.VehicleServiceHistory;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class VehicleServiceRepositoryImpl implements VehicleServiceRepository{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Vehicle-Service");

    @Override
    public VehicleServiceHistory saveVehicleInfo(VehicleServiceHistory entity) {
        System.out.println("Saving all details");
        VehicleServiceHistory save = null;

        EntityManager em = null;
        EntityTransaction et = null;
        try {
            em = this.emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(entity);
            et.commit();
            return save;
        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return save;
    }

    @Override
    public boolean updateRegNumbServiceTypeCostById(String registrationNumber, String serviceType, double serviceCost, int id) {
        System.out.println("updating values");
        boolean update = false;

        EntityManager em = null;
        EntityTransaction et = null;
        try {
            em = this.emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            VehicleServiceHistory found = em.find(VehicleServiceHistory.class, id);
            found.setRegistrationNumber(registrationNumber);
            found.setServiceType(serviceType);
            found.setServiceCost(serviceCost);
            em.merge(found);
            et.commit();
            update = true;
        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }

        return update;
    }

    @Override
    public VehicleServiceHistory updateAllDetailsById(VehicleServiceHistory entity) {
        System.out.println("Updating by Id");
        VehicleServiceHistory updateById = null;

        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = this.emf.createEntityManager();
            et = em.getTransaction();
            System.out.println("begin...........");

            et.begin();
            VehicleServiceHistory update = em.find(VehicleServiceHistory.class, 5);
            update.setRegistrationNumber(entity.getRegistrationNumber());
            update.setServiceType(entity.getServiceType());
            update.setServiceCost(entity.getServiceCost());
            update.setServiceData(entity.getServiceData());
            update.setServiceCenter(entity.getServiceCenter());
            updateById = em.merge(update);
            System.out.println("Commited........");
            et.commit();

        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return updateById;
    }

    @Override
    public boolean deleteById(int id) {
        System.out.println("Deleting Operation");
        boolean delete = false;

        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = this.emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            VehicleServiceHistory deleting = em.find(VehicleServiceHistory.class, id);
            em.remove(deleting);
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
    public VehicleServiceHistory fetchDetailsById(int id) {
        System.out.println("Fetching details by Id");
        VehicleServiceHistory fetch = null;

        EntityManager em = null;
        try {
            em = this.emf.createEntityManager();
              fetch = em.find(VehicleServiceHistory.class, id);

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
    public List<VehicleServiceHistory> findAllVehicleDetails() {
        System.out.println("Finding details of entire table");
        List<VehicleServiceHistory> vehicleEntity = null;

        EntityManager em = null;

        try {
            em = this.emf.createEntityManager();
            Query query = em.createNamedQuery("findAllDetails");
            vehicleEntity = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return vehicleEntity;
    }
}
