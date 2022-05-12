package com.company.leetcode.assessments;

public class RandomCompanyTwo {
    public int[] minOperations(String boxes) {
        int[] result = new int[boxes.length()];
        char[] arr = boxes.toCharArray();
        for(int i=0;i<arr.length;i++) {
            result[i] = numberOfMoves(arr,i);
        }
        return result;
    }

    private int numberOfMoves(char[] arr,int i) {
        boolean done = false;
        int total = 0;
        for (int j=i + 1;j<arr.length;j++) {
            if (arr[j] == '1') {
                total += j - i;
            }
        }
        for (int j=i - 1;j>=0;j--) {
            if (arr[j] == '1') {
                total += i - j;
            }
        }
        return total;
    }

    public static void runTestCases() {
        RandomCompanyTwo r = new RandomCompanyTwo();
        String one = "110";
        String two = "001011";
        int[] result = r.minOperations(one);
        for (int i : result) {
            System.out.print(i + ",");
        }
        System.out.println();
        result = r.minOperations(two);
        for (int i : result) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
