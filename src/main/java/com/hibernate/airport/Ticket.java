package com.hibernate.airport;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="TICKETS")
@NoArgsConstructor
public class Ticket {

    @Id
    @Getter
    @Column(name="ID")
    private int id;


    @Getter
    @Setter
    @Column(name="NUMBER")
    private String number;


    public Ticket(int id, String number) {
        this.id = id;
        this.number = number;
    }

    @ManyToOne
    @Getter
    @Setter
    @JoinColumn(name = "PASSANGER_ID")
    private Passenger passenger;

    
}
