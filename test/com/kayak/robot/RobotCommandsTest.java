package com.kayak.robot;

import com.kayak.robotoldtwo.RobotCommands;
import com.kayak.robotoldtwo.RobotMovements;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

class RobotCommandsTest {

    private RobotCommands commands = null;

    @BeforeEach
    void setUp() {
        commands = new RobotCommands();
    }

    @AfterEach
    void tearDown() {
        commands = null;
    }

    @Test
    void testIllegalDelayCommandArgumentChecking() {
        InvalidParameterException thrown = Assertions.assertThrows(InvalidParameterException.class, () -> {
            String commands = "FRCX";
            RobotCommands cmd = new RobotCommands(commands,-1,1,new int[]{0,0});
        });
    }

    @Test
    void testNullStringCommandArgumentChecking() {
        InvalidParameterException thrown = Assertions.assertThrows(InvalidParameterException.class, () -> {
            String commands = null;
            RobotCommands cmd = new RobotCommands(commands,-1,1,new int[]{0,0});
        });
    }

    @Test
    void testIllegalDelayArgumentChecking() {

        InvalidParameterException thrown = Assertions.assertThrows(InvalidParameterException.class, () -> {
            RobotMovements[] cmdArray = {RobotMovements.LEFT};
            RobotCommands cmd = new RobotCommands(cmdArray,-1,1,new int[]{0,0});
        });
    }

    @Test
    void testIllegalMovementDistanceArgumentChecking() {

        InvalidParameterException thrown = Assertions.assertThrows(InvalidParameterException.class, () -> {
            RobotMovements[] cmdArray = {RobotMovements.LEFT};
            RobotCommands cmd = new RobotCommands(cmdArray,0,-1,new int[]{0,0});
        });
    }


    @Test
    void testIllegalStartingCoordinateArgumentChecking() {

        InvalidParameterException thrown = Assertions.assertThrows(InvalidParameterException.class, () -> {
            RobotMovements[] cmdArray = {RobotMovements.LEFT};
            RobotCommands cmd = new RobotCommands(cmdArray,0,1,null);
        });
    }

    @Test
    void setCommands() {
        RobotMovements[] cmdArray = {RobotMovements.LEFT,RobotMovements.RIGHT,RobotMovements.FORWARD};
        commands.setMovements(cmdArray);
        RobotMovements[] testArray = commands.getMovements();
        assertTrue(testArray[0] == RobotMovements.LEFT);
        assertTrue(testArray[1] == RobotMovements.RIGHT);
        assertTrue(testArray[2] == RobotMovements.FORWARD);
    }

    @Test
    void setDelay() {
        commands.setDelay(5000);
        assertTrue(commands.getDelay() == 5000);
    }

    @Test
    void setStartingCoordinates() {
        commands.setStartingCoordinates(new int[]{5,6});
        int[] coordinates = commands.getStartingCoordinates();
        assertTrue(coordinates[0] == 5);
        assertTrue(coordinates[1] == 6);
    }

    @Test
    void setMovementDistance() {
        commands.setMovementDistance(5);
        assertTrue(commands.getMovementDistance() == 5);
    }


    @Test
    void buildCommands() {
       commands.setCommandsFromString("LRF");
       RobotMovements[] cmds = commands.getMovements();
        assertTrue(cmds[0] == RobotMovements.LEFT);
        assertTrue(cmds[1] == RobotMovements.RIGHT);
        assertTrue(cmds[2] == RobotMovements.FORWARD);
    }
}