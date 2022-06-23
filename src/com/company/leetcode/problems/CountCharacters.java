package com.company.leetcode.problems;

import java.util.Arrays;

import java.util.HashSet;


public class CountCharacters {

    public int countCharacters(String[] words, String chars) {

        int[] temp = new int[26];
        int ans = 0;
        HashSet<Character> st = new HashSet<>();
        for (char c : chars.toCharArray()) {
            temp[c - 'a']++;
        }
        System.out.print(st);
        for (String s : words) {
            if (ismatch(s, temp)) {

                ans += s.length();
            }
        }
        return ans;


    }

    boolean ismatch(String s, int[] temp) {
        int[] temp1 = Arrays.copyOf(temp, temp.length);
        for (char str : s.toCharArray()) {
            if (temp1[str - 'a'] == 0) return false;
            else temp1[str - 'a']--;

        }
        return true;
    }
}