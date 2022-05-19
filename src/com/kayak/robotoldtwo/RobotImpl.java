package com.kayak.robotoldtwo;

public interface RobotImpl {

    /**
     *
     * @param commands
     * @return
     */
    public int[] move(RobotCommands commands);

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
