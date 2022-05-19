package com.kayak.robot;

public abstract class AbstractRobot {
    protected RobotImpl impl = null;

    public AbstractRobot(RobotImpl implementation) {
        super();
        this.impl = implementation;
    }

    public abstract int[] move(String[] instructions,int[] startingCoordinates,int delay,int movementDistance);

    public abstract int[] getCoordinates();

    public abstract void setName(String name);

    public abstract String getName();

    public abstract int getRank();

    public abstract void setRank(int rank);

    public abstract void reportStatus();

}
