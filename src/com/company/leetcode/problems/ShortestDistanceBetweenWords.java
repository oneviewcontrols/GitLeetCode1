package com.company.leetcode.problems;

public class ShortestDistanceBetweenWords {

    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int ans = wordsDict.length;

        for (int i=0, left=-1, right=-1; i<wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                left = i;
            }
            if (wordsDict[i].equals(word2)) {
                right = i;
            }
            if (left > -1 && right > -1) {
                ans = Math.min(Math.abs(right-left), ans);
            }
        }
        return ans;
    }
}
