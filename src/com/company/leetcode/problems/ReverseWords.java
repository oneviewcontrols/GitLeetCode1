package com.company.leetcode.problems;

public class ReverseWords {

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder b = new StringBuilder();
        for (int i=0;i<words.length;i++) {
            b.append(new StringBuilder(words[i]).reverse().toString());
            if ((i + 1) < words.length) {
                b.append(" ");
            }
        }
        return b.toString();
    }

    public static void runTestCases() {
        ReverseWords r = new ReverseWords();
        String str = new String("Let's take LeetCode contest");
        String s = r.reverseWords(str);
        System.out.println(s);
    }
}
