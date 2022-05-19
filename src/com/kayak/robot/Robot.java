package com.kayak.robot;

public class Robot extends AbstractRobot {

    public Robot(RobotImpl robotImpl) {
        super(robotImpl);
    }

    public Robot(RobotImpl robotImpl, String name) {
        super(robotImpl);
        setName(name);
    }

    @Override
    public int[] move(String[] commands,int[] startingCoordinates,int delay,int movementDistance) {
        return impl.move(commands,startingCoordinates,delay,movementDistance);
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
