package com.kayak.questions;

import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.Set;

public class MarsRobot implements Robot{
    private String name = "";
    private int[] coordinates = {0,0};
    // Set allows for expansion of the valid command set
    public Set<String> validCommands = new HashSet<>();
    {
        validCommands.add("F");
        validCommands.add("R");
        validCommands.add("L");
    };

    /**
     * Default Constructor
     */
    public MarsRobot() {
        super();
    }


    /**
     * Move a robot according to the commands passed in and the starting coordinates
     * Valid command characters are 'F','R','L' which stand for Forward, Turn right 90 degrees,
     * Turn left 90 degrees. Starting coordinates are any valid coordinate on a cartesian grid.
     * For example [0,0],[-10,10] etc.
     *
     * @param instructions  String array consisting of only 'F','L', or 'R'
     * @param startingCoordinates Integer Array of size 2, x coordinate and the y coordinate [x,y]
     * @return final coordinates of the robot as x,y
     * @throws InvalidParameterException If any parameter is invalid this exception will be thrown
     */
    @Override
    public int[] move(String[] instructions, int[] startingCoordinates) throws InvalidParameterException {
        /* Note for Reviewer - I know this is an unchecked exception,
           I could skip the parameter check and the existing code would just ignore any
           commands not found in the valid commands set, but informing the caller they have an error
           makes more sense than eating it.
         */
        if (areMoveParametersValid(instructions,startingCoordinates) == false) {
            throw new InvalidParameterException("Invalid arguments passed to MarsRobot::move");
        }
        // Taking an empty command as a valid command, robot doesn't move
        if (instructions.length == 0) return startingCoordinates;
        int x = startingCoordinates[0];
        int y = startingCoordinates[1];
        int xDir = 0; //xDir and yDir Used for Maintaining the orientation of the Robot
        int yDir = 1;
        for (String movement : instructions) {
            if (movement.compareTo("R") == 0) {
                int newX = xDir != 0 ? 0 : yDir;
                yDir = yDir != 0 ? 0 : -xDir;
                xDir = newX;
            } else if (movement.compareTo("L") == 0) {
                int newX = xDir != 0 ? 0 : -yDir;
                yDir = yDir != 0 ? 0 : xDir;
                xDir = newX;
            } else if (movement.compareTo("F") == 0){
                x = x + xDir;
                y = y + yDir;
            }
        }
        coordinates[0] = x;
        coordinates[1] = y;
        return coordinates;

    }

    /**
     * Return the x,y coordinate that the robot currently resides at on a cartesian grid.
     *
     * @return
     */
    @Override
    public int[] getCurrentCoordinates() {
        return coordinates;
    }



    /**
     * Validate the parameters prior to attempting robot movement
     * @param instructions
     * @param startingCoordinates
     * @return false if invalid, true if valid
     */
    private boolean areMoveParametersValid(String[] instructions,int[] startingCoordinates) {
        for (int i=0;i<instructions.length;i++) {
            if (validCommands.contains(instructions[i]) == false) return false;
        }
        if (startingCoordinates.length != 2) return false;
        return true;
    }

    /**
     * @return Name of the robot
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * @param name Set the name of the robot
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    public static void runTestCases() {
        MarsRobot r = new MarsRobot();
        String[] i = {"L","F","F","F","R","F","F","F","R","R","F","F","F"};
        String[] i1 = {"L","F"};
        String[] i2 = {"L","L","F"};
        String[] i3 = {"L","L","L","F"};
        String[] i4 = {"L","L","L","L","F"};
        int[] start = {0,0};
        int[] result = r.move(i,start);
        printIt("LFFFRFFFRRFFF",result);
        result = r.move(i1,start);
        printIt("LF",result);
        result = r.move(i2,start);
        printIt("LLF",result);
        result = r.move(i3,start);
        printIt("LLLF",result);
        result = r.move(i4,start);
        printIt("LLLLF",result);
    }

    private static void printIt(String prefix,int[] results) {
        System.out.print(prefix + " [");
        System.out.print(results[0] + ",");
        System.out.print(results[1]);
        System.out.println("]");
    }

}
