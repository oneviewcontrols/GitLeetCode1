package com.kayak.robot;


public class Robot  {
    protected RobotImpl impl = null;

    public Robot(RobotImpl robotImpl) {
        super();
        this.impl = robotImpl;
        this.impl.setRobot(this);
    }

    public Robot(RobotImpl robotImpl, String name) {
        super();
        this.impl = robotImpl;
        robotImpl.setRobot(this);
        setName(name);
    }

    public int[] move(String[] commands,int[] startingCoordinates,int movementDistance) {
        return impl.move(commands,startingCoordinates,movementDistance);
    }

    public int[] getCoordinates() {
        return impl.getCoordinates();
    }

    public void setName(String name) {
        impl.setName(name);
    }

    public String getName() {
        return impl.getName();
    }

    public void reportStatus() {
        impl.reportStatus();
    }

    public void setAttributeValue(RobotAttributes attribute,String value) {
        impl.setAttributeValue(attribute,value);
    }

    public String getAttributeValue(RobotAttributes attribute) {
        return impl.getAttributeValue(attribute);
    }

    public void addObserver(RobotEvents event, RobotObserver observer) {
        impl.addObserver(event,observer);
    }

    public void removeObserver(RobotEvents event, RobotObserver observer) {
        impl.removeObserver(event,observer);
    }
}
