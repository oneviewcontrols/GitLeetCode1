package com.company.leetcode.problems;

import java.math.BigInteger;

public class ExtraLargeFactorial {

    public static void extraLongFactorials(int n) {
        BigInteger b = new BigInteger(String.valueOf(n));
        System.out.print(fact(b, n));
    }

    static BigInteger fact(BigInteger n, int t){
        BigInteger result = new BigInteger(String.valueOf(1));
        for(int i = 1; i <= t; i++){
            result = result.multiply(new BigInteger(String.valueOf(i)));
        }
        return result;
    }
}
