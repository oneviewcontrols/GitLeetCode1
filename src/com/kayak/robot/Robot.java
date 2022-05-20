package com.kayak.robot;

public class Robot  {
    protected RobotImplOLD impl = null;

    public Robot(RobotImplOLD robotImpl) {
        super();
        this.impl = robotImpl;
        this.impl.setRobot(this);
    }

    public Robot(RobotImplOLD robotImpl, String name) {
        super();
        this.impl = robotImpl;
        robotImpl.setRobot(this);
        setName(name);
    }

    public int[] move(String[] commands,int[] startingCoordinates,int delay,int movementDistance) {
        return impl.move(commands,startingCoordinates,delay,movementDistance);
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
}
