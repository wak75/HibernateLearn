package com.hibernate.airport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PASSENGERS")
@NoArgsConstructor
public class Passenger {

    @Id
    @Getter
    @Column(name = "ID")
    private int id;


    @Column(name="NAME")
    @Getter
    @Setter
    private String name;


    public Passenger(int id, String name) {
        this.id = id;
        this.name = name;
    }


    @ManyToOne
    @JoinColumn(name="AIRPORT_ID")
    @Getter
    @Setter
    private Airport airport;
    

    @OneToMany(mappedBy = "passenger")
    private List<Ticket> tickets = new ArrayList<>();

    public List<Ticket> getTickets(){
        return Collections.unmodifiableList(tickets);
    }

    public void addTicket(Ticket ticket){
        tickets.add(ticket);
    }

}
