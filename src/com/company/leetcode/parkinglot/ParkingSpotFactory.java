package com.company.leetcode.parkinglot;

import java.util.List;
import java.util.Map;

public class ParkingSpotFactory {

    private static ParkingSpotFactory instance = new ParkingSpotFactory();

    public static ParkingSpotFactory getInstance() {
        return instance;
    }

    public List<ParkingSpot> createSpots(Map<VehicleType,Integer> types) {

    }


}
