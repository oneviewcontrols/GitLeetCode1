package com.kayak.questions;

public class RobotOnMarsOne {

    public int[] moveRobot(char[] instructions) {
        if (instructions.length == 0) return new int[]{0,0};
        int x = 0;
        int y = 0;
        int xDir = 0;
        int yDir = 1;
        for (int i=0;i<instructions.length;i++) {
            char movement = instructions[i];
            if (movement == 'R') {
                int newX = xDir != 0 ? 0 : yDir;
                int newY = yDir != 0 ? 0 : -xDir;
                xDir = newX;
                yDir = newY;
            } else if (movement == 'L') {
                int newX = xDir != 0 ? 0 : -yDir;
                int newY = yDir != 0 ? 0 : xDir;
                xDir = newX;
                yDir = newY;
            } else {
                x = x + xDir;
                y = y + yDir;
            }
        }
        return new int[]{x,y};
    }


    public static void runTestCases() {
        RobotOnMarsOne r = new RobotOnMarsOne();
        char[] i = {'L','F','F','F','R','F','F','F','R','R','F','F','F'};
        char[] i1 = {'L','F'};
        char[] i2 = {'L','L','F'};
        char[] i3 = {'L','L','L','F'};
        char[] i4 = {'L','L','L','L','F'};
        int[] result = r.moveRobot(i);
        printIt("LFFFRFFFRRFFF",result);
        result = r.moveRobot(i1);
        printIt("LF",result);
        result = r.moveRobot(i2);
        printIt("LLF",result);
        result = r.moveRobot(i3);
        printIt("LLLF",result);
        result = r.moveRobot(i4);
        printIt("LLLLF",result);
    }

    private static void printIt(String prefix,int[] results) {
        System.out.print(prefix + " [");
        System.out.print(results[0] + ",");
        System.out.print(results[1]);
        System.out.println("]");
    }


}
