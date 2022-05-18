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
    private Direction[] commands = {};
    private int delay = 0;
    private int[] startingCoordinates = {0,0};
    public static enum Direction {
        L("L"),
        R("R"),
        F("F");
        public final String label;
        private Direction(String label) {
            this.label = label;
        }
    }
    private Set<String> validCommands = new HashSet<>();
    {
        validCommands.add(Direction.R.label);
        validCommands.add(Direction.L.label);
        validCommands.add(Direction.F.label);
    };

    public RobotMovementCommands(){
        super();
    }

    /**
     *
     * @param commands F,R,L for Forward, L turn Left 90 degrees, R turn right 90 degrees
     * @param delay time to pause between commands in milliseconds
     * @param startingCoordinates x,y
     */
    public RobotMovementCommands(Direction[] commands, int delay, int[] startingCoordinates) {
        super();
        this.commands = commands;
        this.delay = delay;
    }

    /**
     *
     * @param commands F,R,L for Forward, L turn Left 90 degrees, R turn right 90 degrees
     */
    public void setCommands(String[] commands) {
        this.commands = commands;
    }

    public String[] getCommands() {
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

    /**
     * Checks to ensure that coordinates are x,y and all the commands
     * int the string array are either F,R,L.
     * @return true if valid, false if not
     */
    public boolean instructionsAreValid() {
        if (startingCoordinates.length != 2) return false;
        for (String instruction : commands) {
            if (!validCommands.contains(instruction)) return false;
        }
        return true;
    }

    /**
     * Is the current command an R
     * @param command
     * @return
     */
    public boolean isMoveRight(String command) {
        if (command.equals(Direction.R.label)) return true;
        return false;
    }

    /**
     * Is the current command an L
     * @param command
     * @return
     */
    public boolean isMoveLeft(String command) {
        if (command.equals(Direction.L.label)) return true;
        return false;
    }

    /**
     * Is the current command an F
     * @param command
     * @return
     */
    public boolean isMoveForward(String command) {
        if (command.equals(Direction.F.label)) return true;
        return false;
    }
}
