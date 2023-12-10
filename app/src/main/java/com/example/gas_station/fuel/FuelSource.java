package com.example.gas_station.fuel;

import java.util.ArrayList;
import java.util.List;

public class FuelSource {
    public static List<Fuel> getFuel(){
        List<Fuel> fuel = new ArrayList<>();
        fuel.add(new Fuel("Diesel", 20.00, 65.00));
        fuel.add(new Fuel("Gasoline", 25.00, 650.00));
        return fuel;
    }
}
