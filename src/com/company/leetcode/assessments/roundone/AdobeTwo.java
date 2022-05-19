package com.company.leetcode.assessments.roundone;

import java.util.Arrays;

public class AdobeTwo {

    public int shipWithinDays(int[] weights, int days) {
        int sum = Arrays.stream(weights).sum();
        int high = Arrays.stream(weights).max().getAsInt();
        int low = Math.max((sum/days),high);
        high = sum;


        while(low<high){
            int mid = (low+high)/2;
            if(isValid(weights,days,mid)){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return high;
    }

    public boolean isValid(int[] weights, int days, int j){
        int currCap = 0;
        int day =0;
        for(int i =0; i < weights.length;i++){
            currCap = currCap+ weights[i];
            if(currCap >j){
                day++;
                System.out.println(day);
                currCap = weights[i];
            }
            if(day > days-1) return false;
        }
        return true;
    }

    public static void runTestCases() {
        int[] weights =  {1,2,3,4,5,6,7,8,9,10};
        int[] two = {3,2,2,4,1,4};
        int[] three = {1,2,3,1,1};
        int[] four = {1,2,3,4,5,6,7,8,9,10};
        AdobeTwo t = new AdobeTwo();
        System.out.println(t.shipWithinDays(weights,5));
    }

}
