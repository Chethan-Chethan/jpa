package com.xworkz.workflow.runner;

import com.xworkz.workflow.entity.WorkflowEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class WorkflowUpdate {

    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("workflow-auto");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            WorkflowEntity entity = em.find(WorkflowEntity.class, 1);
            System.out.println(entity);
            entity.setTriggerType("Ticket_pending");
            WorkflowEntity updateEntity = em.merge(entity);
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