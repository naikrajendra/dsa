package com.rpk.dsa;

/**
 * This class provides a method to calculate the nth Fibonacci number using a top-down dynamic programming approach (memoization).
 * The `fibonacci` method computes the Fibonacci number recursively while storing previously computed values in a memoization array to avoid redundant calculations. The time complexity of this approach is O(n), and the space complexity is O(n) due to the memoization array.   
 * Example usage is provided in the `main` method, which calculates and prints the Fibonacci numbers up to a given input n.
 * 
 * FibonacciTopDown
 */

public class FibonacciTopDownDP {

    private int[] memo;
    public FibonacciTopDownDP(int n) {
        memo = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }
    }

    public int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        memo[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 10; // Example input
        FibonacciTopDownDP fibTopDown = new FibonacciTopDownDP(n);
        System.out.print("Fibonacci numbers up to " + n + ": ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibTopDown.fibonacci(i) + " ");
        }
        System.out.println();
    }



}
