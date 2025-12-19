package com.xworkz.movies.runner;

import com.xworkz.movies.entity.MoviesEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MovieUpdate {

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
            System.out.println("old data: " + entity);
            entity.setReleaseYear(2025);
            MoviesEntity updateEntity = em.merge(entity);
            System.out.println("update data: " + updateEntity);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        } finally {
            if (emf != null) {
                emf.close();
            }
            if (em != null) {
                em.close();
            }
        }
    }
}
