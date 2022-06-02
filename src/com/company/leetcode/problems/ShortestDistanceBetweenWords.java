package com.company.leetcode.problems;

public class ShortestDistanceBetweenWords {

    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int ans = wordsDict.length;
        int one = -1;
        int two = -1;
        for (int i=0; i<wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                one = i;
            }
            if (wordsDict[i].equals(word2)) {
                two = i;
            }
            if (one > -1 && two > -1) {
                ans = Math.min(Math.abs(two-one), ans);
            }
        }
        return ans;
    }
}
