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

}
