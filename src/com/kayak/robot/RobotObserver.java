package com.kayak.robot;

public interface RobotObserver {

    public void onEvent(RobotEvent event,Robot robot);
}
