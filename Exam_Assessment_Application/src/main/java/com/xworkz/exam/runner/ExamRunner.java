package com.xworkz.exam.runner;

import com.xworkz.exam.entity.ExamEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ExamRunner {

    public static void main(String[] args) {

        ExamEntity exam = new ExamEntity();
        exam.setExamName("Java Fundamentals");
        exam.setTotalMarks(100);
        exam.setDifficultyLevel("EASY");

        ExamEntity exam1 = new ExamEntity();
        exam1.setExamName("Data Structures");
        exam1.setTotalMarks(150);
        exam1.setDifficultyLevel("HARD");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("exam");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(exam);
            em.persist(exam1);
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