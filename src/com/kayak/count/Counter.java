package com.kayak.count;

public class Counter {

    public void countUp(int start,int end) {
        if (start > end) return;
        System.out.println(start);
        countUp(++start,end);
    }

    public void countUpAndDown(int start,int end) {
        if (start > end) return;
        System.out.println(start);
        countUpAndDown(++start,end);
        --start; // Last recursive call puts start at end + 1
        System.out.println(start);
    }

    public static void runTestCases() {
        Counter c = new Counter();
        c.countUpAndDown(0,5);
        System.out.println();
        System.out.println();
        c.countUpAndDown(0,1);
        System.out.println();
        System.out.println();
        c.countUpAndDown(5,10);
        System.out.println();
        System.out.println();

        c.countUp(0,5);
        System.out.println();
        System.out.println();
        c.countUp(0,1);
        System.out.println();
        System.out.println();
        c.countUp(5,10);
        System.out.println();
        System.out.println();
    }


}
