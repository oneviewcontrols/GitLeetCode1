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
    void testMoveOneLeft() {
        String[] cmds = {"L","F"};
        int[] result = robot.move(cmds,new int[]{0,0},0,1);
        assertTrue(result[0] == -1);
        assertTrue(result[1] == 0);
    }
    @Test
    void testMoveOneRight() {
        String[] cmds = {"R","F"};
        int[] result = robot.move(cmds,new int[]{0,0},0,1);
        assertTrue(result[0] == 1);
        assertTrue(result[1] == 0);
    }

    @Test
    void testMoveOneUp() {
        String[] cmds = {"F"};
        int[] result = robot.move(cmds,new int[]{0,0},0,1);
        assertTrue(result[0] == 0);
        assertTrue(result[1] == 1);
    }

    @Test
    void testMoveOneDown() {
        String[] cmds = {"L","L","F"};
        int[] result = robot.move(cmds,new int[]{0,0},0,1);
        assertTrue(result[0] == 0);
        assertTrue(result[1] == -1);
    }

    @Test
    void testMoveMultipleSpots() {
        String[] cmds = {"F"};
        int[] result = robot.move(cmds,new int[]{0,0},0,2);
        assertTrue(result[0] == 0);
        assertTrue(result[1] == 2);
    }

    @Test
    void testMoveMultipleCommands() {
        String[] cmds = new String("LFFFRFFFRRFFF").split("");
        int[] result = robot.move(cmds,new int[]{0,0},0,1);
        assertTrue(result[0] == -3);
        assertTrue(result[1] == 0);
    }

    @Test
    void testMoveMultipleCommandsAndSpots() {
        String[] cmds = new String("LFFFRFFFRRFFF").split("");
        int[] result = robot.move(cmds,new int[]{0,0},0,3);
        assertTrue(result[0] == -9);
        assertTrue(result[1] == 0);
    }

    @Test
    void testMoveDelay() {
        String[] cmds = {"F"};
        Instant start = Instant.now();
        int[] result = robot.move(cmds,new int[]{0,0},1000,1);
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis()/1000;
        assertTrue(timeElapsed >=+ 1);
    }

    @Test
    void testGetCoordinates() {
        String[] cmds = new String("LFFFRFFFRRFFF").split("");
        int[] result = robot.move(cmds,new int[]{0,0},0,3);
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