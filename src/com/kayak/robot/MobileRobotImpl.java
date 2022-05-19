package com.kayak.robot;

import java.time.Duration;
import java.time.Instant;

public class MobileRobotImpl implements RobotImpl {
    private String name = "";
    private int[] coordinates = {0,0};
    private int rank = 0;

    public MobileRobotImpl() {
        super();
        this.name = "";
    }

    public MobileRobotImpl(String name) {
        super();
        this.name = name;
    }

    @Override
    public int[] move(String[] commands,int[] startingCoordinates,int delay,int movementDistance) {
        int x = startingCoordinates[0];
        int y = startingCoordinates[1];
        int xDir = 0;
        int yDir = 1;
        for (String movement: commands) {
            Instant start = Instant.now();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                System.out.println("RobotDefaultImpl.move caught InterruptedException");
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
        return coordinates;

    }

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
        if (getName().length() > 0) {
            System.out.print(getName() + " Rank is " + getRank());
        } else {
            System.out.print("Rank is " + getRank());
        }
        System.out.println(". Current Coordinates are [" + getCoordinates()[0] + "," + getCoordinates()[1] + "].");

    }
}
