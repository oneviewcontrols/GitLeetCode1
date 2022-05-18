package com.kayak.robot;

public class MobileRobot extends Robot{

    public MobileRobot(RobotImpl robotImpl) {
        super(robotImpl);
    }

    public MobileRobot(RobotImpl robotImpl, String name) {
        super(robotImpl);
        setName(name);
    }

    @Override
    public int[] move(RobotCommands commands) {
        return impl.move(commands);
    }

    @Override
    public int[] getCoordinates() {
        return impl.getCoordinates();
    }

    @Override
    public void setName(String name) {
        impl.setName(name);
    }

    @Override
    public String getName() {
        return impl.getName();
    }

    @Override
    public int getRank() {
        return impl.getRank();
    }

    @Override
    public void setRank(int rank) {
        impl.setRank(rank);
    }

    @Override
    public void reportStatus() {
        impl.reportStatus();
    }
}
