package com.kayak.robot;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

/**
 * NOTE - for expediency in this project I assumed nothing but valid inputs
 * Normally there would be numerous unit tests to check invalid input cases.
 * ALso, there would be unit tests for the RobotRacingService and other classes.
 */

class MobileRobotTest {

    private Robot robot = null;
    private String name = "Test";
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        robot = new Robot(new RacingRobotImpl(),name);
    }

    @AfterEach
    void tearDown() {
        robot = null;
        System.setOut(originalOut);
    }

    @Test
    void testMoveRaceMove() {
        String[] cmds = {"F","R","F","L","L","F","R","F"};
        int[] result = robot.move(cmds,new int[]{0,0},1);
        assertTrue(result[0] == 0);
        assertTrue(result[1] == 2);
    }

    @Test
    void testMoveOneLeft() {
        String[] cmds = {"L","F"};
        int[] result = robot.move(cmds,new int[]{0,0},1);
        assertTrue(result[0] == -1);
        assertTrue(result[1] == 0);
    }
    @Test
    void testMoveOneRight() {
        String[] cmds = {"R","F"};
        int[] result = robot.move(cmds,new int[]{0,0},1);
        assertTrue(result[0] == 1);
        assertTrue(result[1] == 0);
    }

    @Test
    void testMoveOneUp() {
        String[] cmds = {"F"};
        int[] result = robot.move(cmds,new int[]{0,0},1);
        assertTrue(result[0] == 0);
        assertTrue(result[1] == 1);
    }

    @Test
    void testMoveOneDown() {
        String[] cmds = {"L","L","F"};
        int[] result = robot.move(cmds,new int[]{0,0},1);
        assertTrue(result[0] == 0);
        assertTrue(result[1] == -1);
    }

    @Test
    void testMoveMultipleSpots() {
        String[] cmds = {"F"};
        int[] result = robot.move(cmds,new int[]{0,0},2);
        assertTrue(result[0] == 0);
        assertTrue(result[1] == 2);
    }

    @Test
    void testMoveMultipleCommands() {
        String[] cmds = new String("LFFFRFFFRRFFF").split("");
        int[] result = robot.move(cmds,new int[]{0,0},1);
        assertTrue(result[0] == -3);
        assertTrue(result[1] == 0);
    }

    @Test
    void testMoveMultipleCommandsAndSpots() {
        String[] cmds = new String("LFFFRFFFRRFFF").split("");
        int[] result = robot.move(cmds,new int[]{0,0},3);
        assertTrue(result[0] == -9);
        assertTrue(result[1] == 0);
    }

    @Test
    void testMoveDelay() {
        String[] cmds = {"F"};
        robot = new Robot(new RacingRobotImpl(name,1000));
        Instant start = Instant.now();
        int[] result = robot.move(cmds,new int[]{0,0},1);
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis()/1000;
        assertTrue(timeElapsed >=+ 1);
    }

    @Test
    void testGetCoordinatesAfterMove() {
        String[] cmds = new String("LFFFRFFFRRFFF").split("");
        int[] result = robot.move(cmds,new int[]{0,0},3);
        assertTrue(result[0] == -9);
        assertTrue(result[1] == 0);
    }

    @Test
    void testGetCoordinatesMove() {
        String[] cmds = new String("LFFFRFFFRRFFF").split("");
        robot.move(cmds,new int[]{0,0},3);
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
    void testSetAttribute() {
        robot.setAttributeValue(RobotAttributes.RANK,"1");
        robot.reportStatus();
        assertTrue(robot.getAttributeValue(RobotAttributes.RANK).equals("1"));
    }

    @Test
    void testReportStatus() {
        String[] cmds = new String("LFFFRFFFRRFFF").split("");
        robot.move(cmds,new int[]{0,0},3);
        System.setOut(new PrintStream(out));
        robot.reportStatus();
        assertEquals("Test. Current Coordinates are [-9,0].", out.toString().trim());
    }

}