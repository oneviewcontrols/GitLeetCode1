package com.kayak.robot;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class MobileRobotTest {

    private MobileRobot robot = null;
    private String name = "Test";

    @BeforeEach
    void setUp() {
        robot = new MobileRobot(new MobileRobotImpl(),name);
    }

    @AfterEach
    void tearDown() {
        robot = null;
    }

    @Test
    void testMoveNoCommands() {
        RobotCommands cmds = new RobotCommands("");
        cmds.setStartingCoordinates(new int[]{1,1});
        int[] result = robot.move(cmds);
        assertTrue(result[0] == 1);
        assertTrue(result[1] == 1);
    }

    @Test
    void testMoveOneLeft() {
        RobotCommands cmds = new RobotCommands("LF");
        cmds.setStartingCoordinates(new int[]{0,0});
        int[] result = robot.move(cmds);
        assertTrue(result[0] == -1);
        assertTrue(result[1] == 0);
    }
    @Test
    void testMoveOneRight() {
        RobotCommands cmds = new RobotCommands("RF");
        cmds.setStartingCoordinates(new int[]{0,0});
        int[] result = robot.move(cmds);
        assertTrue(result[0] == 1);
        assertTrue(result[1] == 0);
    }

    @Test
    void testMoveOneUp() {
        RobotCommands cmds = new RobotCommands("F");
        cmds.setStartingCoordinates(new int[]{0,0});
        int[] result = robot.move(cmds);
        assertTrue(result[0] == 0);
        assertTrue(result[1] == 1);
    }

    @Test
    void testMoveOneDown() {
        RobotCommands cmds = new RobotCommands("LLF");
        cmds.setStartingCoordinates(new int[]{0,0});
        int[] result = robot.move(cmds);
        assertTrue(result[0] == 0);
        assertTrue(result[1] == -1);
    }

    @Test
    void testMoveMultipleSpots() {
        RobotCommands cmds = new RobotCommands("F");
        cmds.setMovementDistance(2);
        cmds.setStartingCoordinates(new int[]{0,0});
        int[] result = robot.move(cmds);
        assertTrue(result[0] == 0);
        assertTrue(result[1] == 2);
    }

    @Test
    void testMoveMultipleCommands() {
        RobotCommands cmds = new RobotCommands("LFFFRFFFRRFFF");
        cmds.setMovementDistance(1);
        cmds.setStartingCoordinates(new int[]{0,0});
        int[] result = robot.move(cmds);
        assertTrue(result[0] == -3);
        assertTrue(result[1] == 0);
    }

    @Test
    void testMoveMultipleCommandsAndSpots() {
        RobotCommands cmds = new RobotCommands("LFFFRFFFRRFFF");
        cmds.setMovementDistance(3);
        cmds.setStartingCoordinates(new int[]{0,0});
        int[] result = robot.move(cmds);
        assertTrue(result[0] == -9);
        assertTrue(result[1] == 0);
    }

    @Test
    void testMoveOffZeroStartingSpot() {
        RobotCommands cmds = new RobotCommands("");
        cmds.setMovementDistance(1);
        cmds.setStartingCoordinates(new int[]{2,2});
        int[] result = robot.move(cmds);
        assertTrue(result[0] == 2);
        assertTrue(result[1] == 2);
    }

    @Test
    void testMoveDelay() {
        RobotCommands cmds = new RobotCommands("F");
        cmds.setDelay(1500);
        cmds.setStartingCoordinates(new int[]{0,0});
        Instant start = Instant.now();
        int[] result = robot.move(cmds);
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis()/1000;
        assertTrue(timeElapsed >=+ 1);
    }

    @Test
    void testGetCoordinates() {
        RobotCommands cmds = new RobotCommands("LFFFRFFFRRFFF");
        cmds.setMovementDistance(3);
        cmds.setStartingCoordinates(new int[]{0,0});
        robot.move(cmds);
        int[] result = robot.getCoordinates();
        assertTrue(result[0] == -9);
        assertTrue(result[1] == 0);
    }

    @Test
    void testSetName() {
        robot.setName("Foo");
        assertTrue(robot.getName().equals("Foo"));
    }

    @Test
    void testGetName() {
        assertTrue(robot.getName().equals(name));
    }

    @Test
    void testGetRank() {
        assertTrue(robot.getRank() == 0);
    }

    @Test
    void testSetRank() {
        robot.setRank(1);
        assertTrue(robot.getRank() == 1);
    }

}