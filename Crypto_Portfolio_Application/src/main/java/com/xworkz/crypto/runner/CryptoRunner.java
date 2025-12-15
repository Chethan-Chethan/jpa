package com.xworkz.crypto.runner;

import com.xworkz.crypto.entity.CryptoEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CryptoRunner {

    public static void main(String[] args) {
        CryptoEntity entity = new CryptoEntity();
        entity.setAssetName("Bitcoin");
        entity.setBuyPrice(42000);
        entity.setQuantity(0.25);
        entity.setExchange("Binance");

        CryptoEntity entity1 = new CryptoEntity();
        entity1.setAssetName("Ethereum");
        entity1.setBuyPrice(2800);
        entity1.setQuantity(1.5);
        entity1.setExchange("Coinbase");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("crypto_portfolio");
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
            System.out.println("Costly resources closed");
        }
    }
}