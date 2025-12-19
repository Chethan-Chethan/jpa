package com.xworkz.movies.runner;

import com.xworkz.movies.entity.MoviesEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MovieDelete {

    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;
        try {
            emf = Persistence.createEntityManagerFactory("something");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            MoviesEntity entity = em.find(MoviesEntity.class, 1);
            em.remove(entity);
            System.out.println(entity);
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