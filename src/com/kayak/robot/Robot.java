package com.kayak.robot;


import com.kayak.robotoldtwo.RobotImplOLD;

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
