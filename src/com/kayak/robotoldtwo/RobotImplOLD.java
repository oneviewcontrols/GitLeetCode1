package com.kayak.robotoldtwo;

import com.kayak.robot.Robot;
import com.kayak.robot.RobotEvent;
import com.kayak.robot.RobotObserver;

public interface RobotImplOLD {


    public void setRobot(com.kayak.robot.Robot robot);

    public Robot getRobot();

    /**
     * Move the robot based upon the commands passed in, valid commands are "F","R", or "L".
     * @param commands String Array of F,R,L for Forward, Right 90 degrees, Left 90 Degrees
     * @param startingCoordinates x,y int array of length 2
     * @param delay delay between the exection of each command in milliseconds
     * @param movementDistance the distance to move for each forward command
     * @return
     */
    public int[] move(String[] commands,int[] startingCoordinates,int delay,int movementDistance);

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

    public void addObserver(RobotEvent event, RobotObserver observer);

    public void removeObserver(RobotEvent event,RobotObserver observer);

    public void notifyObservers(RobotEvent event);
}
