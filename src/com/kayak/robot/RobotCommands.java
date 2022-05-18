package com.kayak.robot;


import java.security.InvalidParameterException;

public class RobotMovementCommands {
    private RobotMovements[] commands = {};
    private int delay = 0;
    private int movementDistance = 1;
    private int[] startingCoordinates = {0,0};

    public RobotMovementCommands(){
        super();
    }

    public RobotMovementCommands(String commands) {
        super();
        setCommandsFromString(commands);
    }

    /**
     *
     * @param commands String array, Forward F, L turn Left 90 degrees, R turn right 90 degrees
     * @param delay time to pause between commands in milliseconds >= 0
     * @param movementDistance distance to move forward per command, >= 1
     * @param startingCoordinates x,y array length of 2
     */
    public RobotMovementCommands(String commands,int delay,int movementDistance,int[] startingCoordinates) {
        super();
        if ((commands == null) || (delay < 0) || (movementDistance < 1) || (startingCoordinates == null) || (startingCoordinates.length != 2)) {
            throw new InvalidParameterException("commands cannot be null, delay must be 0 or greater, movementDistance must be >= 1, coordinates must be of length 2");
        }
        setCommandsFromString(commands);
        this.delay = delay;
        this.movementDistance = movementDistance;
        this.startingCoordinates = startingCoordinates;
    }

    /**
     *
     * @param commands Forward, LEFT turn Left 90 degrees, RIGHT turn right 90 degrees
     * @param delay time to pause between commands in milliseconds >= 0
     * @param movementDistance distance to move forward per command, >= 1
     * @param startingCoordinates x,y array length of 2
     */
    public RobotMovementCommands(RobotMovements[] commands,
                                 int delay,
                                 int movementDistance,
                                 int[] startingCoordinates) {
        super();
        if ((commands == null) || (delay < 0) || (movementDistance < 1) || (startingCoordinates == null) || (startingCoordinates.length != 2)) {
            throw new InvalidParameterException("commands cannot be null, delay must be 0 or greater, movementDistance must be >= 1, coordinates must be of length 2");
        }
        this.commands = commands;
        this.delay = delay;
        this.movementDistance = Math.abs(movementDistance);
        this.startingCoordinates = startingCoordinates;
    }

    /**
     *
     * @param commands RIGHT, LEFt - turn 90 degrees, FORWARD - move
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

    /**
     *
     * @param movementDistance distance to move on each FORWARD command, 0 or greater
     */
    public void setMovementDistance(int movementDistance) {
        this.movementDistance = movementDistance;
    }

    /**
     *
     * @return Distance to Move on each FORWARD command
     */
    public int getMovementDistance() {
        return movementDistance;
    }

    public void setCommandsFromString(String commands) {
        setCommands(buildCommandsFromString(commands));
    }

    /**
     * Given a string with Forward F, Right R, and Left L create a command array
     * of type RobotMovements
     * @param commands
     * @return
     */
    private RobotMovements[] buildCommandsFromString(String commands) {
        String[] str = commands.split("");
        RobotMovements[] cmds = new RobotMovements[str.length];
        if (commands.length() == 0) return cmds;
        for (int i=0;i<str.length;i++) {
            if (str[i].equals("R")) {
                cmds[i] = RobotMovements.RIGHT;
            } else if (str[i].equals("L")) {
                cmds[i] = RobotMovements.LEFT;
            } else if (str[i].equals("F")) {
                cmds[i] = RobotMovements.FORWARD;
            } else {
                throw new InvalidParameterException(str[i] + " is an invalid command");
            }
        }
        return cmds;
    }
}
