package com.kayak.robot;



/**
 * Class stub to show ability of the bridge pattern to allow n different robots
 * Robots can be created at run time with different abilities and attributes
 * based upon the impl they are initialized with
 */
public class BatteryPoweredRobotImpl extends RobotImpl {

    @Override
    public int[] move(String[] commands, int[] startingCoordinates, int movementDistance) {
        return new int[2];
    }

    /**
     * @return current location of the robot
     */
    @Override
    public int[] getCoordinates() {
        return new int[0];
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public String getName() {
        return null;
    }

    /**
     * Report the current status as defined by the implementing classes
     */
    @Override
    public void reportStatus() {
        System.out.println("I am not implemented yet");
    }
}
