package com.kayak.robot;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class RobotImpl implements RobotImplOLD {
    protected Map<RobotEvent, Set<RobotObserver>> observerMap = new HashMap<>();
    protected Robot reference = null;

    @Override
    public void setRobot(Robot robot) {
        this.reference = robot;
    }

    @Override
    public Robot getRobot() {
        return this.reference;
    }

    /**
     * Move the robot based upon the commands passed in, valid commands are "F","R", or "L".
     * @param commands String Array of F,R,L for Forward, Right 90 degrees, Left 90 Degrees
     * @param startingCoordinates x,y int array of length 2
     * @param delay delay between the exection of each command in milliseconds
     * @param movementDistance the distance to move for each forward command
     * @return
     */
    public abstract int[] move(String[] commands,int[] startingCoordinates,int delay,int movementDistance);

    /**
     *
     * @return current location of the robot
     */
    public abstract int[] getCoordinates();

    public abstract void setName(String name);

    public abstract String getName();

    /**
     * Report the current status as defined by the implementing classes
     */
    public abstract void reportStatus();

    @Override
    public void addObserver(RobotEvent event, RobotObserver observer) {
        Set<RobotObserver> observers = observerMap.get(event);
        observers.add(observer);
        observerMap.put(event,observers);
    }

    @Override
    public void removeObserver(RobotEvent event, RobotObserver observer) {
        Set<RobotObserver> observers = observerMap.get(event);
        observers.remove(observer);
        observerMap.put(event,observers);
    }

    @Override
    public void notifyObservers(RobotEvent event) {
        Set<RobotObserver> observers = observerMap.get(event);
        for (RobotObserver observer : observers) {
            observer.onEvent(event,this.reference);
        }
    }
}
