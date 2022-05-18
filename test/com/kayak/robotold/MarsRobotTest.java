package com.kayak.robotold;

import org.junit.jupiter.api.*;
import java.security.InvalidParameterException;
import static org.junit.jupiter.api.Assertions.*;

class MarsRobotTest {
    private MarsRobot robot;

    @BeforeEach
    void setUp() {
        robot = new MarsRobot();
    }

    @AfterEach
    void tearDown() {
        robot = null;
    }

    @Test
    @DisplayName("Test empty instruction")
    void testMoveEmptyInstructions() {
        // Coordinates should remain unchanged
        String[] instructions = {};
        int[] startingCoordinates = {1,1};
        int[] result = robot.move(instructions,startingCoordinates);
        assertTrue(result[0] == 1);
        assertTrue(result[1] == 1);
    }

    @Test
    @DisplayName("Test Invalid Instructions")
    void testMoveInvalidInstructions() {
        InvalidParameterException thrown = Assertions.assertThrows(InvalidParameterException.class, () -> {
            // Didn't use split("") since down the road commands may be more than one letter
            String[] instructions = "F,F,F,F,L,L,L,L,R,R,R,R,R,X".split(",");
            int[]  startingCoordinates = {0,0};
            robot.move(instructions,startingCoordinates);
        });
    }

    @Test
    @DisplayName("Test Invalid Coordinates - Empty Array")
    void testMoveEmptyCoordinates() {
        InvalidParameterException thrown = Assertions.assertThrows(InvalidParameterException.class, () -> {
            String[] instructions = {};
            int[]  startingCoordinates = {};
            robot.move(instructions,startingCoordinates);
        });
    }

    @Test
    @DisplayName("Test Invalid Coordinates - Array < 2")
    void testMoveCoordinatesLengthSmall() {
        InvalidParameterException thrown = Assertions.assertThrows(InvalidParameterException.class, () -> {
            String[] instructions = {};
            int[]  startingCoordinates = {1};
            robot.move(instructions,startingCoordinates);
        });
    }

    @Test
    @DisplayName("Test Invalid Coordinates - Array > 2")
    void testMoveCoordinatesLengthLarge() {
        InvalidParameterException thrown = Assertions.assertThrows(InvalidParameterException.class, () -> {
            String[] instructions = {};
            int[]  startingCoordinates = {1,2,3};
            robot.move(instructions,startingCoordinates);
        });
    }

    @Test
    void getCurrentCoordinates() {
        int[] currentCoordinates = robot.getCurrentCoordinates();
        assertTrue(currentCoordinates[0] == 0);
        assertTrue(currentCoordinates[1] == 0);
    }

    @Test
    void getName() {
        String name = robot.getName();
        assertTrue(name.length() == 0);
    }

}