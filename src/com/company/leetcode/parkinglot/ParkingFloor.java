package com.company.leetcode.parkinglot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ParkingFloor {
    private Integer floor;
    private Set<VehicleType> restrictions;
    private Map<VehicleType, List<ParkingSpot>> openSpots;
    private Map<VehicleType, List<ParkingSpot>> filledSpots = new HashMap<>();
    // LicensePlate is the PK
    private Map<String,ParkingSpot> vehicleToSpotMap = new HashMap<>();

    public ParkingFloor(Integer number,Set<VehicleType> restrictions,List<ParkingSpot> spots) {

    }


    public int spacesAvailable(VehicleType type) {
        return 0;
    }

    public boolean supportsVehicleType(VehicleType type) {
        return true;
    }

    public boolean park(Vehicle vehicle) {
        List<ParkingSpot> openSpots = openSpots.get(vehicle.getType());
        if (openSpots.size() == 0) return false;
        ParkingSpot spot = openSpots.remove(0);

        return true;
    }

    public boolean exitVehicle(Vehicle vehicle) {
        return true
    }


}
