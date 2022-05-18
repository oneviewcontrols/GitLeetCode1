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
    public int[] move(RobotCommands commands)  {
        RobotMovements[] orders = commands.getMovements();
        if (orders.length == 0) return commands.getStartingCoordinates();
        int movementDistance = commands.getMovementDistance();
        int x = commands.getStartingCoordinates()[0];
        int y = commands.getStartingCoordinates()[0];
        if (orders.length == 0) {
            return coordinates;
        }
        int xDir = 0;
        int yDir = 1;
        for (RobotMovements movement : orders) {
            Instant start = Instant.now();
            try {
                Thread.sleep(commands.getDelay());
            } catch (InterruptedException e) {
                System.out.println("RobotDefaultImpl.move caught InterruptedException");
            }
            if (movement == RobotMovements.RIGHT) {
                int newX = xDir != 0 ? 0 : yDir;
                yDir = yDir != 0 ? 0 : -xDir;
                xDir = newX;
            }
            if (movement == RobotMovements.LEFT) {
                int newX = xDir != 0 ? 0 : -yDir;
                yDir = yDir != 0 ? 0 : xDir;
                xDir = newX;
            } else if  (movement == RobotMovements.FORWARD) {
                x = x + (xDir * movementDistance);
                y = y + (yDir * movementDistance);
            }
            Instant finish = Instant.now();
            long timeElapsed = Duration.between(start, finish).toMillis();
            if (movement != null) reportLatestMovement(movement,movementDistance,timeElapsed);
        }
        coordinates[0] = x;
        coordinates[1] = y;
        return coordinates;

    }

    private void reportLatestMovement(RobotMovements movement,int distance,long timeInMillis) {
        String report = "";
        switch(movement) {
            case LEFT : {
                report = getName().length() > 0 ? getName() + " Turned Left" : "Turned Left";
                break;
            }
            case RIGHT : {
                report = getName().length() > 0 ? getName() + " Turned Right" : "Turned Right";
                break;
            }
            case FORWARD : {
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
