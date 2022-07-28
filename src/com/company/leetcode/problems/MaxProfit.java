package com.company.leetcode.problems;

public class MaxProfit {
    public int maxProfit(int[] prices) {

        int max = 0;
        for (int i=0;i<prices.length;i++) {
            int price = prices[i];
            for (int j=i + 1;j<prices.length;j++) {
                int nextPrice = prices[j];
                if (price >= nextPrice) continue;
                int diff = nextPrice - price;
                max = Math.max(max,diff);
            }
        }
        return max;

    }

    public int maxProfitTheirSolution(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}
