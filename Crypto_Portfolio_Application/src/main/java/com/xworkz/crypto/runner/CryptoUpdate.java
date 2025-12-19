package com.xworkz.crypto.runner;

import com.xworkz.crypto.entity.CryptoEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CryptoUpdate {

    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("crypto_portfolio");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            CryptoEntity entity = em.find(CryptoEntity.class, 2);
            System.out.println(entity);
            entity.setBuyPrice(33000);
            CryptoEntity updateEntity = em.merge(entity);
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