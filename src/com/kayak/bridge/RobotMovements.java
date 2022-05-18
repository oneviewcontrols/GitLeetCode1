package com.kayak.bridge;

/**
 * Prevents the concept of invalid commands being sent to a robot which is possible with
 * String commands. If using a string was a hard requirement then checks would need
 * to be coded into the move method.
 */
public enum RobotMovements {
       LEFT,RIGHT,FORWARD;
}
