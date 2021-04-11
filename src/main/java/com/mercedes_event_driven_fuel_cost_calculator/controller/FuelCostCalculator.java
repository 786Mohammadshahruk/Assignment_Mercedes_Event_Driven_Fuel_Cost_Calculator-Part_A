package com.mercedes_event_driven_fuel_cost_calculator.controller;

import com.mercedes_event_driven_fuel_cost_calculator.model.Fuel;
import com.mercedes_event_driven_fuel_cost_calculator.service.FuelCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class FuelCostCalculator {

    /**
     * creating the object of FuelCostService
     */
    @Autowired
    private FuelCostService fuelCostService;

    /**
     * @param fuelId
     * @param city
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/getFuelCost")
    public ResponseEntity<Object> getValue(@RequestParam(value = "fuelId", required = true) boolean fuelId,
                                           @RequestParam(value = "city", required = true) String city) throws Exception {
        if (fuelId) {
            return new ResponseEntity<Object>((Fuel) fuelCostService.getFuelCost(fuelId, city), HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>("Fuel id of the car is Not opened",HttpStatus.BAD_REQUEST);
        }
    }
}
