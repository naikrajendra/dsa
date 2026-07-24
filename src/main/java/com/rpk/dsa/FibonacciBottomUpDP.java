package com.rpk.dsa;

/**
 * This class provides a method to calculate the nth Fibonacci number using a bottom-up dynamic programming approach (tabulation).
 * The `fibonacci` method computes the Fibonacci number iteratively by building up a table of previously computed values. The time complexity of this approach is O(n), and the space complexity is O(n) due to the array used for tabulation.
 * Example usage is provided in the `main` method, which calculates and prints the Fibonacci numbers up to a given input n. 
 * 
 * FibonacciBottomUpDP
 */

public class FibonacciBottomUpDP {

    public int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        FibonacciBottomUpDP fibBottomUp = new FibonacciBottomUpDP();
        int n = 10; // Example input
        System.out.print("Fibonacci numbers up to " + n + ": ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibBottomUp.fibonacci(i) + " ");
        }
        System.out.println();
    }   


}
