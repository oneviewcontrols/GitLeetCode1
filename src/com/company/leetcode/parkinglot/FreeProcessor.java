package com.company.leetcode.parkinglot;

public class FreeProcessor implements VehicleProcessor{
    @Override
    public boolean parkVehicle(ParkingLot lot, Vehicle vehicle) {
        // if no spaces return false;
        return lot.park(vehicle);

    }

    @Override
    public boolean exitVehicle(ParkingLot lot, Vehicle vehicle) {
        return lot.exitVehicle(vehicle);
    }
}
