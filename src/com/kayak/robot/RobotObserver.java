package com.kayak.robot;

public interface RobotObserver {

    public void onEvent(RobotEvents event, Robot robot);
}
