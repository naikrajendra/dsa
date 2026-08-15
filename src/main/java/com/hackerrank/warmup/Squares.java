package com.hackerrank.warmup;

/**
 * Solution for the "Squares" problem.
 * 
 * Squares
 */
public class Squares {

    public static int squares(int a, int b) {
        // 1. Find the integer square root of the lower bound
        int firstSquareRoot = (int) Math.ceil(Math.sqrt(a));
        
        // 2. Find the integer square root of the upper bound
        int lastSquareRoot = (int) Math.floor(Math.sqrt(b));
        
        // 3. Count total squares between the roots
        if (firstSquareRoot > lastSquareRoot) {
            return 0;
        }
    
        return lastSquareRoot - firstSquareRoot + 1;    
    }

    public static void main(String[] args) {
        int a = 3; // Example input
        int b = 9; // Example input
        int result = squares(a, b);
        System.out.println(result); // Expected output: 2 (4 and 9)
    }

}
