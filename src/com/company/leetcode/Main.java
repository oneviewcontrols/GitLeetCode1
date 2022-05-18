package com.company.leetcode;


import com.kayak.robot.MobileRobot;
import com.kayak.robot.MobileRobotImpl;
import com.kayak.robot.RobotCommands;

public class Main {

    public static void main(String[] args) {
        MobileRobot robot = new MobileRobot(new MobileRobotImpl(),"RobotX");
        RobotCommands commands = new RobotCommands("LFFFRFFFRRFFF");
        robot.move(commands);
        robot.reportStatus();
    }

}




