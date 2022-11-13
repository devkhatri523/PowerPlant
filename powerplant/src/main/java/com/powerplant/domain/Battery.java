package com.powerplant.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Battery")
public class Battery {
    public Battery(){
    }
    public Battery(String name, String postcode, double capacity) {
        this.name = name;
        this.postcode = postcode;
        this.capacity = capacity;
    }

    @Column(name="name" ,length = 50,nullable = false)
    private String name;
    @Id
    @Column(name = "post_code")
    private String postcode;
    @Column(name="capacity")
    private double capacity;

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }



}
