package com.xworkz.movies.runner;

import com.xworkz.movies.entity.MoviesEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

public class MovieRunner {

    public static void main(String[] args) {
        MoviesEntity firstMovie = new MoviesEntity();
        firstMovie.setTitle("Inception");
        firstMovie.setDirector("Christoper Nolan");
        firstMovie.setGener("Science Fiction");
        firstMovie.setReleaseYear(2010);

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("something");
            System.out.println("EntityManagerFactory Created: " + emf);
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            em.persist(firstMovie);
            System.out.println("Movie Data inserted");

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
