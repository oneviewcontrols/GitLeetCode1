package com.company.leetcode.assessments.roundone;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RandomCompanyThree {

    public String removeOuterParentheses(String s) {
        char[] str = s.toCharArray();
        int leftCount = 0;
        int startIndex = 0;
        List<String> ret = new ArrayList<>();
        for (int i=0;i<str.length;i++) {
            if (str[i] == '(') leftCount++;
            if (str[i] == ')') leftCount--;
            if (leftCount == 0) {
                String sub = s.substring(startIndex,i + 1);
                ret.add(sub);
                startIndex = i + 1;
            }
        }
        Iterator<String> it = ret.iterator();
        StringBuilder builder = new StringBuilder();
        while (it.hasNext()) {
            String p = it.next();
            p = p.substring(1,p.length() - 1);
            builder.append(p);
        }

        return builder.toString();
    }

    public static void runTestCases() {
        RandomCompanyThree r = new RandomCompanyThree();
        String s = "(()())(())";
        String s2 = "(()())(())(()(()))";
        String s3 = "()()";
        System.out.println(r.removeOuterParentheses(s));
        System.out.println(r.removeOuterParentheses(s2));
        System.out.println(r.removeOuterParentheses(s3));
    }
}
