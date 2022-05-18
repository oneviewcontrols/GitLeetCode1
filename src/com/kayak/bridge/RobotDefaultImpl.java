package com.kayak.bridge;

import java.security.InvalidParameterException;

public class RobotDefaultImpl implements RobotImpl {
    private String name = "";
    private int[] coordinates = {0,0};
    private int rank = 0;

    public RobotDefaultImpl() {
        super();
        this.name = "";
    }

    public RobotDefaultImpl(String name) {
        super();
        this.name = name;
    }

    @Override
    public int[] move(RobotMovementCommands commands) throws InvalidParameterException {
        String[] orders = commands.getCommands();
        int x = commands.getStartingCoordinates()[0];
        int y = commands.getStartingCoordinates()[0];
        if (!commands.instructionsAreValid()) {
            throw new InvalidParameterException();
        }
        if (orders.length == 0) {
            return coordinates;
        }
        int xDir = 0;
        int yDir = 1;
        for (String movement : orders) {
            try {
                Thread.sleep(commands.getDelay());
            } catch (InterruptedException e) {
                // Would normally log this, not going to raise it
                // since it won't effect the final location
                // even though it will effect the timing of arrival.
                System.out.println("RobotDefaultImpl.move caught InterruptedException");
            }
            if (commands.isMoveRight(movement)) {
                int newX = xDir != 0 ? 0 : yDir;
                yDir = yDir != 0 ? 0 : -xDir;
                xDir = newX;
            } else if (commands.isMoveLeft(movement)) {
                int newX = xDir != 0 ? 0 : -yDir;
                yDir = yDir != 0 ? 0 : xDir;
                xDir = newX;
            } else if (commands.isMoveForward(movement)){
                x = x + xDir;
                y = y + yDir;
            }
        }
        coordinates[0] = x;
        coordinates[1] = y;
        return coordinates;

    }

    @Override
    public int[] getCoordinates() {
        return this.coordinates;
    }

    @Override
    public void setName(String name) {
       this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getRank() {
        return this.rank;
    }

    @Override
    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public void reportStatus() {
        System.out.println("Current Coordinates are [" + getCoordinates()[0] + "," + getCoordinates()[1] + "]");
        System.out.println("Rank is " + getRank());
    }
}
