package com.kayak.bridge;

import java.security.InvalidParameterException;

public abstract class Robot {
    protected RobotImpl impl = null;

    public Robot(RobotImpl implementation) {
        super();
        this.impl = implementation;
    }

    public abstract int[] move(RobotMovementCommands instructions);

    public abstract int[] getCoordinates();

    public abstract void setName(String name);

    public abstract String getName();

    public abstract int getRank();

    public abstract void setRank(int rank);

    public abstract void reportStatus();

}
