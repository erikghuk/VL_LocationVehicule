package com.erik.model;

import java.util.ArrayList;
import java.util.List;

public class Parc {
    private List<Vehicle> vehicles;
    public Parc() {
        vehicles = new ArrayList<>();
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }


    public void addInParc(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeFromParc(Vehicle vehicle) {
            vehicles.remove(vehicle);
    }
}
