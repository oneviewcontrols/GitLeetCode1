package com.kayak.robotoldtwo;

public abstract class AbstractRobot {
    protected RobotImplOLD impl = null;

    public AbstractRobot(RobotImplOLD implementation) {
        super();
        this.impl = implementation;
    }

    public abstract int[] move(String[] instructions,int[] startingCoordinates,int delay,int movementDistance);

    public abstract int[] getCoordinates();

    public abstract void setName(String name);

    public abstract String getName();

    public abstract void reportStatus();

}
