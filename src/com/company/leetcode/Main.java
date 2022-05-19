package com.company.leetcode;


import com.kayak.robot.Robot;
import com.kayak.robot.RacingRobotImpl;


public class Main {

    public static void main(String[] args) {
        Robot robot = new Robot(new RacingRobotImpl(),"RobotX");
        String[] commands = new String("LFFFRFFFRRFFF").split("");
        robot.move(commands,new int[]{0,0},1000,1);
        robot.reportStatus();
    }

}




