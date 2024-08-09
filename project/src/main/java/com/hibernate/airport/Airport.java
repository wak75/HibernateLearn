package com.hibernate.airport;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "AIRPORTS")
@Access(AccessType.FIELD)
@NoArgsConstructor
public class Airport {
    @Id
    @Getter
    @Column(name = "ID")
    private int id;


    @Column(name="NAME")
    @Getter
    @Setter
    private String name;


    public Airport(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @OneToMany(mappedBy = "airport")
    private List<Passenger> passengers  = new ArrayList<>();


    public List<Passenger> getPassengers(){
        return Collections.unmodifiableList(passengers);
    }

    public void addPassenger(Passenger passenger){
        passengers.add(passenger);
    }
}
