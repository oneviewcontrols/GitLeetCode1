package com.company.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();

        for (int i=0;i<numRows;i++) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j=0;j<=i;j++) {
                row.add(new Integer(1));
            }
            ret.add(row);
        }

        for (int i=2;i<numRows;i++) {
            List<Integer> previousRow = ret.get(i - 1);
            List<Integer> row = ret.get(i);
            for (int j=1;j<previousRow.size();j++) {
                int val = previousRow.get(j - 1) + previousRow.get(j);
                Integer colVal = row.set(j,new Integer(val));
            }
        }
        return ret;
    }
}
