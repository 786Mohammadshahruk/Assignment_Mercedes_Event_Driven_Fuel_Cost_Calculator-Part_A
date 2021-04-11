package com.mercedes_event_driven_fuel_cost_calculator.service;

import com.mercedes_event_driven_fuel_cost_calculator.model.Fuel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class FuelCostService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FuelCostService.class);
    private static int MERCEDES_FUEL_TANK_CAPACITY = 80;
    private static int carTakeOneLitterFuel = 30;

    /**
     * service method is used to get fuel cost
     *
     * @param fuelId
     * @param city
     * @return
     * @throws Exception
     */
    public Fuel getFuelCost(boolean fuelId, String city) throws Exception {
        HashMap<String, Double> fuelCost = fuelCostBasedOnCity();
        Fuel fuel = new Fuel();
        if (fuelCost.containsKey(city) && fuelId) {
            fuel.setCity(city);
            fuel.setFuellid(fuelId);
            double fuelPrice = fuelCost.get(city);
            fuel.setAmountOfFuel(MERCEDES_FUEL_TANK_CAPACITY);
            LOGGER.info("The Total Amount Of The Fuel Is {} liter in {} minutes  ", MERCEDES_FUEL_TANK_CAPACITY, (carTakeOneLitterFuel * MERCEDES_FUEL_TANK_CAPACITY) / 60);
            fuel.setPrice(fuelPrice * MERCEDES_FUEL_TANK_CAPACITY);
            LOGGER.info("The total price is = {} ", fuelPrice * MERCEDES_FUEL_TANK_CAPACITY);
            return fuel;
        } else {
            throw new Exception("City is Not Found...!");
        }
    }

    /**
     * Mocked method it will return fuel cost based on city
     *
     * @return
     */
    private HashMap<String, Double> fuelCostBasedOnCity() {
        HashMap<String, Double> hashMap = new HashMap();
        hashMap.put("Bangalore", 93.59);
        hashMap.put("Mysore", 93.67);
        hashMap.put("New Delhi", 90.56);
        hashMap.put("North Delhi", 90.56);
        hashMap.put("North Delhi", 96.98);
        return hashMap;
    }
}
