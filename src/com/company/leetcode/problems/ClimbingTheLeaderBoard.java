package com.company.leetcode.problems;

import java.util.*;

public class ClimbingTheLeaderBoard {

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> scores) {
        Set<Integer> set = new HashSet<>();
        for (Integer i : ranked) {
            set.add(i);
        }
        Integer[] rank = set.toArray(new Integer[set.size()]);
        Arrays.sort(rank,Collections.reverseOrder());
        List<Integer> retList = new ArrayList<>();
        for (int i=0;i<scores.size();i++) {
            int score = scores.get(i).intValue();
            boolean rankSet = false;
            for (int x=0;x<rank.length;x++) {
                if ((score > rank[x].intValue()) || (score == rank[x].intValue())) {
                    retList.add(x + 1);
                    rankSet = true;
                    break;
                }
            }
            if (rankSet == false) {
                retList.add(rank.length + 1);
            }
        }
        return retList;
    }

}
