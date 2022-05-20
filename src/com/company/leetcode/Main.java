package com.company.leetcode;


import com.kayak.count.Counter;
import com.kayak.robot.racing.RobotRacingService;


public class Main {

    public static void main(String[] args) {
        RobotRacingService service = RobotRacingService.getInstance();
        service.raceRobots();
        countUp(0,5);
        countUpAndDown(0,10);
    }

    public static void countUp(int start,int end) {
        if (start > end) return;
        System.out.println(start);
        countUp(++start,end);
    }

    public static void countUpAndDown(int start,int end) {
        if (start > end) return;
        System.out.println(start);
        countUpAndDown(++start,end);
        --start; // Last recursive call puts start at end + 1
        System.out.println(start);
    }

}




