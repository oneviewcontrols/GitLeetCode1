package com.company.leetcode.assessments.amazon;

import java.util.*;

public class AmazonQuestionOne {

    public static List<List<Integer>> findRestaurants(List<List<Integer>> allLocations, int numRestaurants) {
        if (numRestaurants == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> returnList = new ArrayList<>();
        Collections.sort(allLocations, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                Double distanceOne =  Math.sqrt((o1.get(0) * o1.get(0) + (o1.get(1) * o1.get(1))));
                Double distanceTwo =  Math.sqrt((o2.get(0) * o2.get(0) + (o2.get(1) * o2.get(1))));
                if (distanceOne == distanceTwo) {
                    int returnResult = Math.abs(o1.get(0)) < Math.abs(o2.get(0)) ? -1 : 1;
                    return returnResult;
                }
                return distanceOne < distanceTwo ? -1 : 1;
            }
        });

        for (int i=0;i<numRestaurants;i++) {
            returnList.add(allLocations.get(i));
        }
        return returnList;
    }


    private static double computeDistance(int x,int y) {
        return Math.sqrt((x * x) + (y * y));
    }
}
