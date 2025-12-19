package com.xworkz.movie1.runner;

import com.xworkz.movie1.entity.MovieEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MovieRunner {

    public static void main(String[] args) {
        MovieEntity entity = new MovieEntity();
        entity.setTitle("KGF");
        entity.setDirector("Prashant Neel");
        entity.setGenre("Violence");
        entity.setReleaseYear(2021);

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;
        try {
            emf = Persistence.createEntityManagerFactory("movies");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(entity);
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
        }
    }
}