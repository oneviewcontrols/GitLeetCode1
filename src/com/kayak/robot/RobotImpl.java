package com.kayak.robot;

import com.kayak.robotoldtwo.RobotImplOLD;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class RobotImpl {
    protected Map<RobotEvent, Set<RobotObserver>> observerMap = new HashMap<>();
    protected Map<RobotAttributes,String> attributeMap = new HashMap<>();
    protected Robot reference = null;
    protected String name = "";
    protected int[] coordinates = {0,0};

    public void setRobot(Robot robot) {
        this.reference = robot;
    }

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
    public int[] getCoordinates() {
        return this.coordinates;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    /**
     * Report the current status as defined by the implementing classes
     */
    public abstract void reportStatus();


    public void addObserver(RobotEvent event, RobotObserver observer) {
        Set<RobotObserver> observers = observerMap.get(event);
        if (observers == null) {
            observers = new HashSet<>();
        }
        observers.add(observer);
        observerMap.put(event,observers);
    }


    public void removeObserver(RobotEvent event, RobotObserver observer) {
        Set<RobotObserver> observers = observerMap.get(event);
        observers.remove(observer);
        observerMap.put(event,observers);
    }

    public void notifyObservers(RobotEvent event) {
        Set<RobotObserver> observers = observerMap.get(event);
        if (observers == null) return;
        for (RobotObserver observer : observers) {
            observer.onEvent(event,this.reference);
        }
    }

    public void setAttribute(RobotAttributes attribute,String value) {
        attributeMap.put(attribute,value);
    }
    public void removeAttribute(RobotAttributes attribute) {
        attributeMap.remove(attribute);
    }
    public String getAttributeValue(RobotAttributes attribute) {
        String value = getAttributeValue(attribute) != null ? getAttributeValue(attribute) : "";
        return value;
    }
}
