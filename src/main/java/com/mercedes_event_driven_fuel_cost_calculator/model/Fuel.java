package com.mercedes_event_driven_fuel_cost_calculator.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Table;
import java.io.Serializable;

@EntityScan
@Table(name = "fuel")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Fuel implements Serializable {

    private boolean fuellid ;
    private String city;
    private double price;
    private double amountOfFuel;

    public double getAmountOfFuel() {
        return amountOfFuel;
    }

    public void setAmountOfFuel(double amountOfFuel) {
        this.amountOfFuel = amountOfFuel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isFuellid() {
        return fuellid;
    }

    public void setFuellid(boolean fuellid) {
        this.fuellid = fuellid;
    }
}
