package com.kayak.robot;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class RobotService implements RobotObserver{
    private static RobotService instance = null;
    private int rank = 1;


    public static RobotService getInstance() {
        if (instance == null) {
            instance = new RobotService();
        }
        return instance;
    }

    public void raceRobots() {
        try {
            rank = 1;
            List<Robot> robots = new ArrayList<>();
            Robot joe = new Robot(new RacingRobotImpl(), "Joe");
            Robot bill = new Robot(new RacingRobotImpl(), "Bill");
            Robot jim = new Robot(new RacingRobotImpl(), "Jim");
            joe.addObserver(RobotEvents.STOP, this);
            bill.addObserver(RobotEvents.STOP, this);
            jim.addObserver(RobotEvents.STOP, this);
            CountDownLatch latch = new CountDownLatch(1);
            RacerThread joesThread = new RacerThread(joe, latch, 0, "FRFLLFRF");
            RacerThread billsThread = new RacerThread(bill, latch, 1000, "FFFFFLF");
            RacerThread jimsThread = new RacerThread(jim, latch, 2000, "LFRF");
            joesThread.start();
           // billsThread.start();
           // jimsThread.start();
            latch.await();
        }  catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Race Terminated Due to an Exception");
        }

    }

    @Override
    public void onEvent(RobotEvents event, Robot robot) {
        if (event == RobotEvents.STOP) {
            handleStopEvent(robot);
        }
    }

    private void handleStopEvent(Robot robot) {
        robot.setAttributeValue(RobotAttributes.RANK,Integer.toString(rank));
        robot.reportStatus();
        rank++;
    }

    private class RacerThread extends Thread {
        private CountDownLatch latch = null;
        private Robot robot = null;
        private int movementDelay = 0;
        private String commands = "";

        public RacerThread(Robot robot,
                           CountDownLatch latch,
                           int movementDelay,
                           String commands) {
            super(robot.getName());
            this.latch = latch;
            this.robot = robot;
            this.movementDelay = movementDelay;
            this.commands = commands;
        }

        @Override
        public void run() {
            int[] startingCoordinates = {0,0};
            int movementDistance = 1;
            robot.move(commands.split(""),startingCoordinates,movementDelay,movementDistance);
            latch.countDown();
        }
    }

}
