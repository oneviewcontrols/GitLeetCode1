package com.kayak.bridge;

import java.util.HashSet;
import java.util.Set;

/*
    The purpose of this class is to allow future expansion as to what an instruction can be
    without having to change existing robot code.
    If a future robot requires an integer array for example instead of a string array
    that can be easily accommodated without changing existing robots that use the strings.

 */
public class RobotMovementCommands {
    private RobotMovements[] commands = {};
    private int delay = 0;
    private int[] startingCoordinates = {0,0};

    public RobotMovementCommands(){
        super();
    }

    /**
     *
     * @param commands F,R,L for Forward, L turn Left 90 degrees, R turn right 90 degrees
     * @param delay time to pause between commands in milliseconds
     * @param startingCoordinates x,y
     */
    public RobotMovementCommands(RobotMovements[] commands, int delay, int[] startingCoordinates) {
        super();
        this.commands = commands;
        this.delay = delay;
    }

    /**
     *
     * @param commands F,R,L for Forward, L turn Left 90 degrees, R turn right 90 degrees
     */
    public void setCommands(RobotMovements[] commands) {
        this.commands = commands;
    }

    public RobotMovements[] getCommands() {
        return commands;
    }

    /**
     *
     * @param delay time to pause between commands in milliseconds
     */
    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getDelay() {
        return this.delay;
    }

    public int[] getStartingCoordinates() {
        return startingCoordinates;
    }

    /**
     *
     * @param startingCoordinates x,y
     */
    public void setStartingCoordinates(int[] startingCoordinates) {
        this.startingCoordinates = startingCoordinates;
    }

}
