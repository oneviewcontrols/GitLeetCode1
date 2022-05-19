package com.company.leetcode.problems;

public class IntegerToRoman {
    static int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    static String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public String intToRomanOld(int num) {
        int n = num;
        StringBuilder str = new StringBuilder();
        for (int i=0;n>0;i++) {
            while (n>=values[i]) {
                str.append(roman[i]);
                n -= values[i];
            }
        }
        return str.toString();
    }
}
