package com.kayak.robotold;

import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.Set;

public class MarsRobot implements Robot{
    private String name = "";
    private int[] coordinates = {0,0};
    public Set<String> validCommands = new HashSet<>();
    {
        validCommands.add("F");
        validCommands.add("R");
        validCommands.add("L");
    };

    public MarsRobot() {
        super();
    }

    @Override
    public int[] move(String[] instructions, int[] startingCoordinates) throws InvalidParameterException {
        if (areMoveParametersValid(instructions,startingCoordinates) == false) {
            throw new InvalidParameterException();
        }
        if (instructions.length == 0) return startingCoordinates;
        int x = startingCoordinates[0];
        int y = startingCoordinates[1];
        int xDir = 0;
        int yDir = 1;
        for (String movement : instructions) {
            if (movement.equals("R")) {
                int newX = xDir != 0 ? 0 : yDir;
                yDir = yDir != 0 ? 0 : -xDir;
                xDir = newX;
            } else if (movement.equals("L")) {
                int newX = xDir != 0 ? 0 : -yDir;
                yDir = yDir != 0 ? 0 : xDir;
                xDir = newX;
            } else if (movement.equals("F")){
                x = x + xDir;
                y = y + yDir;
            }
        }
        coordinates[0] = x;
        coordinates[1] = y;
        return coordinates;

    }

    private boolean areMoveParametersValid(String[] instructions,int[] startingCoordinates) {
        if (startingCoordinates.length != 2) return false;
        for (String instruction : instructions) {
            if (!validCommands.contains(instruction)) return false;
        }
        return true;
    }

    @Override
    public int[] getCurrentCoordinates() {
        return coordinates;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

}
