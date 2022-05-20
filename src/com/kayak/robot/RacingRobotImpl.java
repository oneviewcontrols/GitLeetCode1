package com.kayak.robot;

import java.time.Duration;
import java.time.Instant;

public class RacingRobotImpl extends RobotImpl {

    public RacingRobotImpl() {
        super();
        this.name = "";
        this.movementDelay = 0;
    }

    public RacingRobotImpl(String name,int movementDelay) {
        super();
        this.name = name;
        this.movementDelay = movementDelay;
    }

    /**
     * NOTE - For the purpose of this exercise all inputs assumed to be valid
     */
    @Override
    public int[] move(String[] commands,int[] startingCoordinates,int movementDistance) {
        int x = startingCoordinates[0];
        int y = startingCoordinates[1];
        int xDir = 0;
        int yDir = 1;
        notifyObservers(RobotEvents.START);
        for (String movement: commands) {
            Instant start = Instant.now();
            try {
                Thread.sleep(movementDelay);
            } catch (InterruptedException e) {
                System.out.println("RacingRobotImpl.move caught InterruptedException");
            }
            if (movement.equals("R")) {
                int newX = xDir != 0 ? 0 : yDir;
                yDir = yDir != 0 ? 0 : -xDir;
                xDir = newX;
            }
            if (movement.equals("L")) {
                int newX = xDir != 0 ? 0 : -yDir;
                yDir = yDir != 0 ? 0 : xDir;
                xDir = newX;
            } else if  (movement.equals("F")) {
                x = x + (xDir * movementDistance);
                y = y + (yDir * movementDistance);
            }
            Instant finish = Instant.now();
            long timeElapsed = Duration.between(start, finish).toMillis();
            reportLatestMovement(movement,movementDistance,timeElapsed);
        }
        coordinates[0] = x;
        coordinates[1] = y;
        notifyObservers(RobotEvents.STOP);
        return coordinates;

    }

    /**
     * Report the latest movement of the robot which includes new coordinates, distance traveled,
     * and time since last movement
     * @param movement
     * @param distance
     * @param timeInMillis
     */
    private void reportLatestMovement(String movement, int distance, long timeInMillis) {
        String report = "";
        switch(movement) {
            case "L" : {
                report = getName().length() > 0 ? getName() + " Turned Left" : "Turned Left";
                break;
            }
            case "R" : {
                report = getName().length() > 0 ? getName() + " Turned Right" : "Turned Right";
                break;
            }
            case "F" : {
                report = getName().length() > 0 ? getName() + " Moved Forward" : "Moved Forward ";
                report += new StringBuffer(" " + Integer.toString(distance)).toString();
                break;
            }
        }
        long seconds = timeInMillis/1000;
        System.out.println(report + ", " + seconds + " second(s) since last movement.");
    }

    @Override
    public int[] getCoordinates() {
        return this.coordinates;
    }

    @Override
    public void reportStatus() {
        String prefix = getAttributeValue(RobotAttributes.RANK);
        if (prefix.length() != 0) {
            prefix = getName().length() > 0 ? getName() + "s Rank is " + prefix : "Rank is " + prefix + ".";
        } else {
            prefix = getName();
        }
        if (prefix.length() > 0) {
            System.out.println(prefix + ". Current Coordinates are [" + getCoordinates()[0] + "," + getCoordinates()[1] + "].");
        } else {
            System.out.println("Current Coordinates are [" + getCoordinates()[0] + "," + getCoordinates()[1] + "].");
        }
    }
}
