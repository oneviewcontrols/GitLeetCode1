package com.kayak.robotold;

import java.security.InvalidParameterException;

/*
 * Robot interface, there can be N types of robot
*/
public interface Robot {

    /**
     * Move robot in cartesian grid. F = Forward, L = Left (90 degrees) R = Right (90 degrees)
     * @param instructions String array consisting of commands, currently only "F","L","R"
     * @param startingCoordinates x,y length must equal 2
     * @return
     * @throws InvalidParameterException Instructions other than F,R,L or start coordinates not = 2
     */
    public int[] move(String[] instructions,int[] startingCoordinates) throws InvalidParameterException;

    /**
     * @return  x,y
     */
    public int[] getCurrentCoordinates();

    public String getName();

    public void setName(String name);

}
