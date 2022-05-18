package com.kayak.robot;


import java.security.InvalidParameterException;

public class RobotCommands {
    private RobotMovements[] movements = {};
    private int delay = 0;
    private int movementDistance = 1;
    private int[] startingCoordinates = {0,0};
    public static enum DIR {
        LEFT,RIGHT,FORWARD;
    }

    public RobotCommands(){
        super();
    }

    public RobotCommands(String movementCommands) {
        super();
        setCommandsFromString(movementCommands);
    }

    /**
     *
     * @param movementCommands String array, Forward F, L turn Left 90 degrees, R turn right 90 degrees
     * @param delay time to pause between commands in milliseconds >= 0
     * @param movementDistance distance to move forward per command, >= 1
     * @param startingCoordinates x,y array length of 2
     */
    public RobotCommands(String movementCommands, int delay, int movementDistance, int[] startingCoordinates) {
        super();
        if ((movementCommands == null) || (delay < 0) || (movementDistance < 1) || (startingCoordinates == null) || (startingCoordinates.length != 2)) {
            throw new InvalidParameterException("commands cannot be null, delay must be 0 or greater, movementDistance must be >= 1, coordinates must be of length 2");
        }
        setCommandsFromString(movementCommands);
        this.delay = delay;
        this.movementDistance = movementDistance;
        this.startingCoordinates = startingCoordinates;
    }

    /**
     *
     * @param movements Forward, LEFT turn Left 90 degrees, RIGHT turn right 90 degrees
     * @param delay time to pause between commands in milliseconds >= 0
     * @param movementDistance distance to move forward per command, >= 1
     * @param startingCoordinates x,y array length of 2
     */
    public RobotCommands(RobotMovements[] movements,
                         int delay,
                         int movementDistance,
                         int[] startingCoordinates) {
        super();
        if ((movements == null) || (delay < 0) || (movementDistance < 1) || (startingCoordinates == null) || (startingCoordinates.length != 2)) {
            throw new InvalidParameterException("commands cannot be null, delay must be 0 or greater, movementDistance must be >= 1, coordinates must be of length 2");
        }
        this.movements = movements;
        this.delay = delay;
        this.movementDistance = Math.abs(movementDistance);
        this.startingCoordinates = startingCoordinates;
    }

    /**
     *
     * @param movements RIGHT, LEFt - turn 90 degrees, FORWARD - move
     */
    public void setMovements(RobotMovements[] movements) {
        this.movements = movements;
    }

    public RobotMovements[] getMovements() {
        return movements;
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

    public void setCommandsFromString(String movementCommands) {
        setMovements(buildMovementsFromString(movementCommands));
    }

    /**
     * Given a string with Forward F, Right R, and Left L create a command array
     * of type RobotMovements
     * @param movementCommands
     * @return
     */
    private RobotMovements[] buildMovementsFromString(String movementCommands) {
        String[] str = movementCommands.split("");
        RobotMovements[] cmds = new RobotMovements[str.length];
        if (movementCommands.length() == 0) return cmds;
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
