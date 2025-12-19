package com.xworkz.exam.runner;

import com.xworkz.exam.entity.ExamEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ExamUpdate {
    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;
        try {
            emf = Persistence.createEntityManagerFactory("exam");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            ExamEntity entity = em.find(ExamEntity.class, 1);
            System.out.println(entity);
            entity.setDifficultyLevel("Medium");
            ExamEntity updateEntity = em.merge(entity);
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