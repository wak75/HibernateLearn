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
@NoArgsConstructor
@Table(name = "PASSENGERS")
@SecondaryTable(name= "ADDRESSES", 
    pkJoinColumns = @PrimaryKeyJoinColumn(name = "ADD_PASSENGER_ID", referencedColumnName = "PASSENGER_ID"))
public class Passenger {

    @Id
    @Column(name = "PASSENGER_ID", table = "PASSENGERS")
    @Getter
    private int id;

    @Getter
    @Setter
    @Column(name= "PASSENGER_NAME", table = "PASSENGERS")
    private String name;

    @Getter
    @Setter
    @Column(name = "STREET", table = "ADDRESSES", columnDefinition = "varchar(50) not null")
    private String street;

    @Column(name = "ZIPCODE", table = "ADDRESSES", columnDefinition = "varchar(50) not null")
    @Getter
    @Setter
    private String zipcode;

    @Getter
    @Setter
    @Column(name = "CITY", table = "ADDRESSES", columnDefinition = "varchar(20) not null")
    private String city;

    public Passenger(int id, String name) {
        this.id = id;
        this.name = name;
    }

   
    

}
