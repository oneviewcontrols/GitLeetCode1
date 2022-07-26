package com.company.leetcode.parkinglot;

public class LotController {
    private VehicleProcessor processor;
    private ParkingLot lot;

    public LotController(VehicleProcessor processor,ParkingLot lot){

    }

    public boolean parkVehicle(Vehicle vehicle) {
        processor.parkVehicle(this.lot,vehicle);
    }


}
