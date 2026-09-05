package com.hackerrank.warmup;

/**
 * Determines the maximum number of chocolates that can be eaten given the initial money, 
 * cost per chocolate, and wrapper exchange rate.
 * 
 * ChocolateFeast
 */
public class ChocolateFeast {

    public static int chocolateFeast(int n, int c, int m) { 
        int chocolatesBought = n / c; // Initial chocolates bought
        int wrappers = chocolatesBought; // Initial wrappers from bought chocolates

        // Keep exchanging wrappers for chocolates while possible
        while (wrappers >= m) {
            int additionalChocolates = wrappers / m;
            chocolatesBought += additionalChocolates;
            wrappers = wrappers % m + additionalChocolates;
        }

        return chocolatesBought;
    }

    public static void main(String[] args) {
        int n = 10; // Total money
        int c = 2;  // Cost per chocolate
        int m = 5;  // Wrappers needed for a free chocolate

        int result = chocolateFeast(n, c, m);
        System.out.println(result);
    }
}
