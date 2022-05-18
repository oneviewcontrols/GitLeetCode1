package com.kayak.bridge;

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
    public int[] move(RobotMovementCommands commands)  {
        RobotMovements[] orders = commands.getCommands();
        int x = commands.getStartingCoordinates()[0];
        int y = commands.getStartingCoordinates()[0];
        if (orders.length == 0) {
            return coordinates;
        }
        int xDir = 0;
        int yDir = 1;
        for (RobotMovements movement : orders) {
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
