package com.kayak.questions;

import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.Set;

/*
 * Robot interface, there can be N types of robots
*/
public interface Robot {

    /**
     * Move a robot according to the commands passed in and the starting coordinates
     * Valid command characters are 'F','R','L' which stand for Forward, Turn right 90 degrees,
     * Turn left 90 degrees. Starting coordinates are any valid coordinate on a cartesian grid.
     * For example [0,0],[-10,10] etc.
     * @param instructions String array consisting of commands, currently only "F","L","R"
     * @param startingCoordinates Integer Array of size 2, x coordinate and the y coordinate [x,y]
     * @return
     * @throws InvalidParameterException If any parameter is invalid this exception will be thrown
     */
    public int[] move(String[] instructions,int[] startingCoordinates) throws InvalidParameterException;

    /**
     * Return the x,y coordinate that the robot currently resides at on a cartesian grid.
     * @return x,y coordinate of the robot x in int[0], y in int[1]
     */
    public int[] getCurrentCoordinates();

    /**
     *
     * @return Name of the robot
     */
    public String getName();

    /**
     *
     * @param name
     */
    public void setName(String name);

}
