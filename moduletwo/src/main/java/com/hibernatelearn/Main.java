package com.hibernatelearn;

import com.hibernatelearn.airport.Passenger;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatelearn.m2");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Passenger washim  = new Passenger(1, "Washim Akram Khan", "India, West Bengal");
        em.persist(washim);
        em.getTransaction().commit();
        
        emf.close();
    }
}