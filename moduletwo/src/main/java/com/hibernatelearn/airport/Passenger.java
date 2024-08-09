package com.hibernatelearn.airport;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PASSENGERS")
@SecondaryTable(name = "ADDRESSES", 
    pkJoinColumns = @PrimaryKeyJoinColumn(name = "PASSENGER_ID", referencedColumnName = "PASSENGER_ID"))
@NoArgsConstructor
public class Passenger {

    @Id
    @Column(name= "PASSENGER_ID")
    @Getter
    private int id;

    @Getter
    @Setter
    @Column(name = "PASSENGER_NAME", table = "PASSENGERS")
    private String name;

    @Getter
    @Setter
    @Column(name = "PASSENGER_ADDRESS", table = "ADDRESSES", columnDefinition = "varchar(25) not null")
    private String address;

    public Passenger(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    
}
