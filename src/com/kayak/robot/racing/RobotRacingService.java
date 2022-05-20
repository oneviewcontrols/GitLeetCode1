package com.kayak.robot.racing;

import com.kayak.robot.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class RobotRacingService implements RobotObserver, RacerThreadListener {
    private static RobotRacingService instance = null;
    private List<Robot> finishOrderList = new ArrayList<>();
    private int rank = 1;
    private int numRacersOnCourse = 0;

    public static RobotRacingService getInstance() {
        if (instance == null) {
            instance = new RobotRacingService();
        }
        return instance;
    }

    /**
     * Convenience method to execute the project.
     * A real race service would have a much better method building
     * and executing a race with n robots.
     */
    public void raceRobots() {
        try {
            rank = 1;
            numRacersOnCourse = 3;
            List<Robot> robots = new ArrayList<>();
            Robot joe = new Robot(new RacingRobotImpl("Joe",3000));
            Robot bill = new Robot(new RacingRobotImpl("Bill",1000));
            Robot jim = new Robot(new RacingRobotImpl("Jim",2000));

            joe.addObserver(RobotEvents.STOP, this);
            bill.addObserver(RobotEvents.STOP, this);
            jim.addObserver(RobotEvents.STOP, this);

            CountDownLatch latch = new CountDownLatch(3);

            RacerThread joesThread = new RacerThread(joe, latch,  "FRFLLFRF",this);
            RacerThread billsThread = new RacerThread(bill, latch, "FFFFFLF",this);
            RacerThread jimsThread = new RacerThread(jim, latch,  "LFRF",this);

            joesThread.start();
            billsThread.start();
            jimsThread.start();
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
        rank++;
    }

    public void racerFinished(Robot robot) {
        numRacersOnCourse--;
        finishOrderList.add(robot);
        if (numRacersOnCourse == 0) {
            for (Robot racer : finishOrderList) {
                racer.reportStatus();
            }
        }
    }
}
