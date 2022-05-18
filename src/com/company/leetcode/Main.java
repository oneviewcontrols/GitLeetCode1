package com.company.leetcode;


import com.kayak.bridge.MoveableRobot;
import com.kayak.bridge.MoveableRobotImpl;
import com.kayak.bridge.RobotMovementCommands;
import com.kayak.bridge.RobotMovements;
import com.kayak.count.Counter;
import com.kayak.robot.MarsRobot;
import com.kayak.robot.Robot;

import java.time.Duration;
import java.time.Instant;

public class Main {

    public static void main(String[] args) {
        MoveableRobot robot = new MoveableRobot(new MoveableRobotImpl(),"RobotX");
        RobotMovementCommands commands = buildCommands("LFFFRFFFRRFFF");
        robot.move(commands);
        robot.reportStatus();
    }

    public static RobotMovementCommands buildCommands(String commands) {
        String[] str = commands.split("");
        RobotMovements[] cmds = new RobotMovements[str.length];
        for (int i=0;i<str.length;i++) {
            if (str[i].equals("R")) {
                cmds[i] = RobotMovements.RIGHT;
            } else if (str[i].equals("L")) {
                cmds[i] = RobotMovements.LEFT;
            } else if (str[i].equals("F")) {
                cmds[i] = RobotMovements.FORWARD;
            }
        }
        return new RobotMovementCommands(cmds,1000,1,new int[]{0,0});
    }


}




