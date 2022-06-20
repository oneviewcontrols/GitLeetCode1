package com.company.leetcode.problems;

import java.util.Arrays;

public class FlatLandSpaceStations {

    // Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] c) {
        if (n == c.length) return 0;
        Arrays.sort(c);
        int max = c[0];
        for (int i=1;i<c.length;i++) {
            int distance = (c[i] - c[i - 1]) / 2;
            max = Math.max(max,distance);
        }
        int last = (n - 1) - c[c.length - 1];
        max = max > last ? max : last;
        return max;

    }
}
