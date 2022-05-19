package com.company.leetcode;


import com.kayak.robot.MobileRobot;
import com.kayak.robot.MobileRobotImpl;


public class Main {

    public static void main(String[] args) {
        MobileRobot robot = new MobileRobot(new MobileRobotImpl(),"RobotX");
        String[] commands = new String("LFFFRFFFRRFFF").split("");
        robot.move(commands,new int[]{0,0},1000,1);
        robot.reportStatus();
    }

}




