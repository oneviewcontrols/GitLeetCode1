package com.kayak.robot;

import java.time.Duration;
import java.time.Instant;

public class TurnRight extends RobotCommand {



    public TurnRight(RobotImpl robot) {
        super(robot);
    }

    @Override
    public void execute() {
        int[] currentLocation = robot.getCoordinates();
        int movementDelay = robot.getMovementDelay();
        int x = currentLocation[0];
        int y = currentLocation[1];
        int xDir = 0;
        int yDir = 1;
        robot.notifyObservers(RobotEvents.START);
        Instant start = Instant.now();
        try {
            Thread.sleep(movementDelay);
        } catch (InterruptedException e) {
            System.out.println("RacingRobotImpl.move caught InterruptedException");
        }
        int newX = xDir != 0 ? 0 : yDir;
         yDir = yDir != 0 ? 0 : -xDir;
         xDir = newX;


            Instant finish = Instant.now();
            long timeElapsed = Duration.between(start, finish).toMillis();
           // robot.reportLatestMovement(movement,movementDistance,timeElapsed);
        //currentLocation[0] = x;
        //currentLocation[1] = y;
        //robot.setCoordinates(currentLocation);
       // robot.notifyObservers(RobotEvents.STOP);
    }
}
