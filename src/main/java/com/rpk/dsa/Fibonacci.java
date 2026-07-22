package com.rpk.dsa;

/**
 * This class provides a method to calculate the nth Fibonacci number using an iterative approach.
 * The `fibonacci` method computes the Fibonacci number with a for loop by adding the two preceding numbers in the sequence. The time complexity of this approach is O(n), and the space complexity is O(1).   
 * Example usage is provided in the `main` method, which calculates and prints the Fibonacci number for a given input n.
 * 
 * Fibonacci
 */

public class Fibonacci {

    public int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int previous = 0;
        int current = 1;
        for (int i = 2; i <= n; i++) {
            int next = previous + current;
            previous = current;
            current = next;
        }
        return current;
    }

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        int n = 10; // Example input
        System.out.print("Fibonacci numbers up to " + n + ": ");
        for (int i = 0; i < n; i++) {
            System.out.print(fib.fibonacci(i));
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

}
