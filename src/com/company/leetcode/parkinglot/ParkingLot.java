package com.company.leetcode.parkinglot;

import java.util.Map;

public abstract class ParkingLot {
    Map<Integer,ParkingFloor> floors;

    public int openSpaces(Integer floor,VehicleType type) {
        return floors.get(floor).spacesAvailable(type);
    }

    public int openSpaces(VehicleType type) {
        int total = 0;
        for (Integer f : floors.keySet()) {
            total += floors.get(f).spacesAvailable(type);
        }
        return total;
    }

    public boolean park(Vehicle vehicle) {

    }

    public boolean exitVehicle(Vehicle vehicle) { return true; }
}
