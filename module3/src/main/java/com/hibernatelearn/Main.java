package com.hibernatelearn;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import com.hibernatelearn.airport.Passenger;


public class Main {
    public static void main(String[] args) {
        

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatelearn.m3");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Passenger washim = new Passenger(1, "Washim");
        washim.setStreet("good Street");
        washim.setZipcode("778899");
        washim.setCity("Nice city");

        em.persist(washim);
        em.getTransaction().commit();

        em.close();


    }
}