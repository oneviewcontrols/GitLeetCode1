package com.kayak.bridge;

public class MoveableRobot extends Robot{

    public MoveableRobot(RobotImpl robotImpl) {
        super(robotImpl);
    }

    public MoveableRobot(RobotImpl robotImpl,String name) {
        super(robotImpl);
        setName(name);
    }

    @Override
    public int[] move(RobotMovementCommands commands) {
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
