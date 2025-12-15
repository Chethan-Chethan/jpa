package com.xworkz.workflow.runner;

import com.xworkz.workflow.entity.WorkflowEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class WorkflowRunner {

    public static void main(String[] args) {
        WorkflowEntity entity = new WorkflowEntity();
        entity.setWorkflowName("Ticket Auto Assign");
        entity.setTriggerType("TICKET_CREATED");
        entity.setActionType("ASSIGN_AGENT");

        WorkflowEntity entity1 = new WorkflowEntity();
        entity1.setWorkflowName("Email Alert");
        entity1.setTriggerType("PAYMENT_FAILED");
        entity1.setActionType("SEND_EMAIL");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("workflow-auto");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
//        em.persist(entity);
        em.persist(entity1);
        System.out.println("Data inserted into db");
        et.commit();

        emf.close();
        em.close();
        System.out.println("Costly resources closed successfully");
    }
}
