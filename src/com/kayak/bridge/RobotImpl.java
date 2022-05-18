package com.kayak.bridge;

import java.security.InvalidParameterException;

public interface RobotImpl {

    /**
     *
     * @param instructions
     * @return
     * @throws InvalidParameterException Thrown since an invalid command effects final location
     */
    public int[] move(RobotMovementCommands instructions) throws InvalidParameterException;

    /**
     *
     * @return current location of the robot
     */
    public int[] getCoordinates();

    public void setName(String name);

    public String getName();

    public int getRank();

    public void setRank(int rank);

    /**
     * Report the current status as defined by the implementing classes
     */
    public void reportStatus();
}
