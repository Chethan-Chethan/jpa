package com.xworkz.onlinepayment.repository;

import com.xworkz.onlinepayment.entity.PaymentEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class PaymentRepositoryImpl implements PaymentRepository{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("payment");

    @Override
    public PaymentEntity savePaymentInfo(PaymentEntity entity) {
        System.out.println("Insert data");
//        PaymentEntity insert = null;

        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = this.emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(entity);
            et.commit();
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return null;
    }

    @Override
    public boolean updateAmountPaymentModeTransactionStatusById(double amount, String paymentMode, String transactionStatus, int id) {
        System.out.println("Update Transaction");
        boolean update = false;

        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = this.emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            PaymentEntity found = em.find(PaymentEntity.class, id);
            if (found != null) {
                found.setAmount(amount);
                found.setPaymentMode(paymentMode);
                found.setTransactionStatus(transactionStatus);
            }
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
    public PaymentEntity updateAllDetailsById(PaymentEntity entity) {
        System.out.println("Invoking update");

        EntityManager em = null;
        EntityTransaction et = null;
        try {
            em = this.emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            PaymentEntity update = em.find(PaymentEntity.class, 1);
            update.setUserReference(entity.getUserReference());
            update.setAmount(entity.getAmount());
            update.setPaymentMode(entity.getPaymentMode());
            update.setTransactionStatus(entity.getTransactionStatus());
            update.setTransactionTime(entity.getTransactionTime());
            et.commit();
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        System.out.println("Invoking delete");
        boolean delete = false;

        EntityManager em = null;
        EntityTransaction et = null;
        try {
            em = this.emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            PaymentEntity deleting = em.find(PaymentEntity.class, id);
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
    public PaymentEntity findPaymentEntityById(int id) {
        System.out.println("Deleting");
        PaymentEntity fetching = null;
        EntityManager em = null;
        try {
            em = this.emf.createEntityManager();
            fetching = em.find(PaymentEntity.class, id);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        System.out.println("Running");
        return fetching;
    }

    @Override
    public List<PaymentEntity> findAllPaymentDetails() {
        System.out.println("FInd all the details of payments");
        List<PaymentEntity> paymentEntities = null;

        EntityManager em = null;

        try {
            em = this.emf.createEntityManager();
            Query query = em.createNamedQuery("findAllDetails");
            paymentEntities = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return paymentEntities;
    }
}
