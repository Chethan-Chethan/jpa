package com.xworkz.subscription.runner;

import com.xworkz.subscription.entity.SubscriptionEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SubscriptionRunner {
    public static void main(String[] args) {
        SubscriptionEntity entity = new SubscriptionEntity();
        entity.setCustomerName("John Doe");
        entity.setPlanName("Premium");
        entity.setMonthlyFee(999.0);
        entity.setActive(true);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("subscription");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(entity);
        System.out.println("Successfully inserted");
        et.commit();

        emf.close();
        em.close();
    }
}
