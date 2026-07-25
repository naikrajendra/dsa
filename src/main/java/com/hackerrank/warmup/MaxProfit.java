package com.hackerrank.warmup;

import java.util.Arrays;

public class MaxProfit {

    // Predictable Retail Pattern: Best time to buy and sell stocks.
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // Track lowest buying price
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice; // Update max profit only when a later sell price is better
            }
        }

        return maxProfit;
    }

    private static void runTest(String title, int[] prices, int expected) {
        MaxProfit solver = new MaxProfit();
        int result = solver.maxProfit(prices);

        System.out.println("\n" + title);
        System.out.println("Prices: " + Arrays.toString(prices));
        System.out.println("Expected: " + expected);
        System.out.println("Actual:   " + result);
        System.out.println(result == expected ? "PASS" : "FAIL");
    }

    public static void main(String[] args) {
        runTest("Test 1: Increasing prices", new int[] { 1, 2, 3, 4, 5 }, 4);
        runTest("Test 2: Decreasing prices", new int[] { 7, 6, 4, 3, 1 }, 0);
        runTest("Test 3: Single dip", new int[] { 7, 1, 5, 3, 6, 4 }, 5);
        runTest("Test 4: Max before min", new int[] { 7, 6, 4, 3, 1, 5 }, 4);
        runTest("Test 4: Max before min", new int[] { 7, 6, 4, 3, 1, 5 }, 4);
        runTest("Test 4: Max before min", new int[] { 7, 6, 4, 3, 1, 5 }, 4);
        runTest("Test 6: Null prices", null, 0);
        runTest("Test 7: Empty prices", new int[] {}, 0);
    }
}
