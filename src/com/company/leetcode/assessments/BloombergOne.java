package com.company.leetcode.assessments;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BloombergOne {
    Map<Character,Character> map = new HashMap<>();
    {
        map.put(')','(');
    }

    public int maxDepth(String s) {
        if (s.length() == 0) return 0;
        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i=0;i<s.length();i++) {
            if ((chars[i] == '(') || (chars[i] == ')')) {
                builder.append(chars[i]);
            }
        }
        chars = builder.toString().toCharArray();
        int maxDepth = 0;
        for (int i=0;i<chars.length;i++) {
            if (map.containsKey(chars[i])) {
                if (stack.empty()) return 0;
                Character open = stack.pop();
                if (open.charValue() != map.get(chars[i])) {
                    return 0;
                }
            } else {
                stack.push(chars[i]);
                maxDepth = stack.size() > maxDepth ? stack.size() : maxDepth;
            }
        }
        if (stack.empty() == false) return 0;
        return maxDepth;
    }

    public static void runTestCases() {
        BloombergOne a = new BloombergOne();
        String one = "";
        String two = "(C)";
        String three = "(A + B)";
        String four = "()()";
        String five = "()((((())))())";
        String six = "(adadsads()";
        System.out.println("One = " + a.maxDepth(one));
        System.out.println("Two = " + a.maxDepth(two));
        System.out.println("Three = " + a.maxDepth(three));
        System.out.println("Four = " + a.maxDepth(four));
        System.out.println("Five = " + a.maxDepth(five));
        System.out.println("Six = " + a.maxDepth(six));

    }
}
