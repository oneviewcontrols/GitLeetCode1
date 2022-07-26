package com.company.leetcode.parkinglot;

public class PayOnExitProcessor implements VehicleProcessor{
    @Override
    public boolean parkVehicle(ParkingLot lot, Vehicle vehicle) {
        return false;
    }

    @Override
    public boolean exitVehicle(ParkingLot lot, Vehicle vehicle) {
        return false;
    }
}
