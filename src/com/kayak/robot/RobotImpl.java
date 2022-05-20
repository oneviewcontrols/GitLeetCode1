package com.kayak.robot;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class RobotImpl {
    protected Map<RobotEvents, Set<RobotObserver>> observerMap = new HashMap<>();
    protected Map<RobotAttributes,String> attributeMap = new HashMap<>();
    protected Robot reference = null;
    protected String name = "";
    protected int[] coordinates = {0,0};
    protected int movementDelay = 0; // in milliseconds


    /**
     * Move the robot based upon the commands passed in, valid commands are "F","R", or "L".
     * @param commands String Array of F,R,L for Forward, Right 90 degrees, Left 90 Degrees
     * @param startingCoordinates x,y int array of length 2
     * @param movementDistance the distance to move for each forward command
     * @return
     */
    public abstract int[] move(String[] commands,int[] startingCoordinates,int movementDistance);


    public abstract void reportStatus();


    public void addObserver(RobotEvents event, RobotObserver observer) {
        Set<RobotObserver> observers = observerMap.get(event);
        if (observers == null) {
            observers = new HashSet<>();
        }
        observers.add(observer);
        observerMap.put(event,observers);
    }


    public void removeObserver(RobotEvents event, RobotObserver observer) {
        Set<RobotObserver> observers = observerMap.get(event);
        observers.remove(observer);
        observerMap.put(event,observers);
    }

    public void notifyObservers(RobotEvents event) {
        Set<RobotObserver> observers = observerMap.get(event);
        if (observers == null) return;
        for (RobotObserver observer : observers) {
            observer.onEvent(event,this.reference);
        }
    }

    public void setAttributeValue(RobotAttributes attribute,String value) {
        attributeMap.put(attribute,value);
    }
    public void removeAttribute(RobotAttributes attribute) {
        attributeMap.remove(attribute);
    }
    public String getAttributeValue(RobotAttributes attribute) {
        String value = attributeMap.get(attribute) != null ? attributeMap.get(attribute) : "";
        return value;
    }

    public void setRobot(Robot robot) {
        this.reference = robot;
    }

    public Robot getRobot() {
        return this.reference;
    }

    public int[] getCoordinates() {
        return this.coordinates;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getMovementDelay() {
        return movementDelay;
    }

}
