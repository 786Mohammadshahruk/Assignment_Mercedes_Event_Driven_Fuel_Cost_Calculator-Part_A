package com.mercedes_event_driven_fuel_cost_calculator.service;

import com.mercedes_event_driven_fuel_cost_calculator.MercedesEventDrivenFuelCostCalculatorApplication;
import com.mercedes_event_driven_fuel_cost_calculator.model.Fuel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = MercedesEventDrivenFuelCostCalculatorApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class FuelCostServiceTest {

    @Autowired
    private FuelCostService fuelCostService;

    /**
     * method is used to calculate the amount of fuel got into the tank and get the  price when fuel id is true
     *
     * @throws Exception
     */
    @Test
    public void getAllTheValuesWhenFuelIdIsTrue() throws Exception {
        boolean fuelId = true;
        String city = "Bangalore";
        Fuel fuel = fuelCostService.getFuelCost(fuelId, city);
        assertEquals(true, fuel.isFuellid());
        assertEquals("Bangalore", fuel.getCity());
        assertTrue(fuel.getPrice() != 0);
        assertTrue(fuel.getAmountOfFuel() != 0);
    }

    /**
     * method is used to calculate the amount of fuel got into the tank and get the  price when fuel id is false
     *
     * @throws Exception
     */
    @Test
    public void getAllTheValuesWhenFuelIdIsFalse() throws Exception {
        boolean fuelId = false;
        String city = "Bangalore";
        try {
            Fuel fuel = fuelCostService.getFuelCost(fuelId, city);
        } catch (Exception e) {
            assertEquals("City is Not Found...!", e.getMessage());
        }
    }
}
