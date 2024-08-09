package com.hibernate;

import com.hibernate.airport.Airport;
import com.hibernate.airport.Passenger;
import com.hibernate.airport.Ticket;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatelearn");
        
        EntityManager em =  emf.createEntityManager();

        em.getTransaction().begin();

        //Creating the airport object
        Airport igi = new Airport(1,"Indera Gandhi Intenational");
        
        //Creating the Passangers object
        Passenger washim = new Passenger(1, "Washim Akram Khan");
        Passenger shruti = new Passenger(2, "Shruti Singh");
        
        //Setting the Airport for the passangers
        washim.setAirport(igi);
        shruti.setAirport(igi);

        //Adding passangers to airport
        igi.addPassenger(shruti);
        igi.addPassenger(washim);

        //Creating ticket objects 
        Ticket wasTicket1 = new Ticket(1, "AA1234");
        Ticket wasTicket2 = new Ticket(3, "AA7890");
        Ticket shrutiTicket = new Ticket(2,"BB5678");

        //setting the passangers for the ticket
        wasTicket1.setPassenger(washim);
        wasTicket2.setPassenger(washim);
        shrutiTicket.setPassenger(shruti);

        //Assigning tickets to passangers
        washim.addTicket(wasTicket1);
        washim.addTicket(wasTicket2);
        shruti.addTicket(shrutiTicket);

        //Persisting the Airport
        em.persist(igi);

        //Persisting the passangers
        em.persist(washim);
        em.persist(shruti);

        //persisting the tickets
        em.persist(shrutiTicket);
        em.persist(wasTicket1);
        em.persist(wasTicket2);

        em.getTransaction().commit();

        emf.close();
    }
}