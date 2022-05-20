package com.kayak.robot;

/**
 * Class stub to show ability of the bridge pattern to allow n different robots
 * Robots can be created at run time with different abilities and attributes
 * based upon the impl they are initialized with
 */
public class BatteryPoweredRobotImpl implements RobotImplOLD {
    /**
     * Move the robot based upon the commands passed in, valid commands are "F","R", or "L".
     *
     * @param commands            String Array of F,R,L for Forward, Right 90 degrees, Left 90 Degrees
     * @param startingCoordinates x,y int array of length 2
     * @param delay               delay between the exection of each command in milliseconds
     * @param movementDistance    the distance to move for each forward command
     * @return
     */
    @Override
    public int[] move(String[] commands, int[] startingCoordinates, int delay, int movementDistance) {
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

    @Override
    public int getRank() {
        return 0;
    }

    @Override
    public void setRank(int rank) {

    }

    /**
     * Report the current status as defined by the implementing classes
     */
    @Override
    public void reportStatus() {
        System.out.println("I am not implemented yet");
    }
}
