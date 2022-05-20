package com.kayak.robot.racing;

import com.kayak.robot.Robot;

import java.util.concurrent.CountDownLatch;

public class RacerThread extends Thread {
    private CountDownLatch latch = null;
    private Robot robot = null;
    private int movementDelay = 0;
    private String commands = "";
    private RacerThreadListener listener = null;

    public RacerThread(Robot robot,
                       CountDownLatch latch,
                       int movementDelay,
                       String commands,
                       RacerThreadListener listener) {
        super(robot.getName());
        this.latch = latch;
        this.robot = robot;
        this.movementDelay = movementDelay;
        this.commands = commands;
        this.listener = listener;
    }

    @Override
    public void run() {
        int[] startingCoordinates = {0,0};
        int movementDistance = 1;
        robot.move(commands.split(""),startingCoordinates,movementDelay,movementDistance);
        this.listener.racerFinished(robot);
        latch.countDown();
    }
}
