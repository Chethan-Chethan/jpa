package com.xworkz.subscriptionplan.repository;

import com.xworkz.subscriptionplan.entity.SubscriptionEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class SubscriptionRepositoryImpl implements SubscriptionRepository{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("subscription");

    @Override
    public SubscriptionEntity saveSubscriptionInfo(SubscriptionEntity entity) {
        System.out.println("Saving subscription info");
        SubscriptionEntity save = null;

        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = this.emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(entity);
            et.commit();
            save = em.merge(entity);
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
    public boolean updatePriceDurationMonthsMaxUsersById(double price, int durationMonths, int maxUsers, int planId) {
        System.out.println("Updating using plan Id");
        boolean update = false;

        EntityManager em = null;
        EntityTransaction et = null;
        try {
            em = this.emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            SubscriptionEntity isupdate = em.find(SubscriptionEntity.class, planId);
            isupdate.setPrice(price);
            isupdate.setDurationMonths(durationMonths);
            isupdate.setMaxUsers(maxUsers);
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
    public SubscriptionEntity updateAllDetailById(SubscriptionEntity entity) {
        System.out.println("Update all details");
        SubscriptionEntity updateAll = null;

        EntityManager em = null;
        EntityTransaction et = null;
        try {
            em = this.emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            SubscriptionEntity updating = em.find(SubscriptionEntity.class, entity.getPlanId());
            updating.setPlanName(entity.getPlanName());
            updating.setPrice(entity.getPrice());
            updating.setDurationMonths(entity.getDurationMonths());
            updating.setMaxUsers(entity.getMaxUsers());
            updating.setActive(entity.isActive());
            et.commit();
            updateAll = em.merge(updating);
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
        System.out.println("Performing delete operation");
        boolean delete = false;

        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = this.emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            SubscriptionEntity del = em.find(SubscriptionEntity.class, id);
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
    public SubscriptionEntity findSubscriptionPlanById(int id) {
        System.out.println("Fetching details by Id");
        SubscriptionEntity fetch = null;

        EntityManager em = null;

        try {
            em = this.emf.createEntityManager();
            fetch = em.find(SubscriptionEntity.class, id);
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
    public List<SubscriptionEntity> findAllDetails() {
        System.out.println("Invoking findAllMethod in repository Impl");
        List<SubscriptionEntity> entity = null;

        EntityManager em = null;
        try {
            em = this.emf.createEntityManager();
            Query query = em.createNamedQuery("findAllSubscriptionEntities");
            entity = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return entity;
    }
}
