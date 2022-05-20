package com.kayak.robot.racing;

import com.kayak.robot.Robot;

import java.util.concurrent.CountDownLatch;

public class RacerThread extends Thread {
    private CountDownLatch latch = null;
    private Robot robot = null;
    private String commands = "";
    private RacerThreadListener listener = null; // Would be a collection to allow n listeners



    public RacerThread(Robot robot,
                       CountDownLatch latch,
                       String commands,
                       RacerThreadListener listener) {
        super(robot.getName());
        this.latch = latch;
        this.robot = robot;
        this.commands = commands;
        this.listener = listener;
    }

    @Override
    public void run() {
        int[] startingCoordinates = {0,0};
        int movementDistance = 1;
        robot.move(getCommands().split(""),startingCoordinates,movementDistance);
        this.listener.racerFinished(robot);
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    public void setLatch(CountDownLatch latch) {
        this.latch = latch;
    }

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    public String getCommands() {
        return commands;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

    public RacerThreadListener getListener() {
        return listener;
    }

    public void setListener(RacerThreadListener listener) {
        this.listener = listener;
    }
}
