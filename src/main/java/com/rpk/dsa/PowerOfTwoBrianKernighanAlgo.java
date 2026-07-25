package com.rpk.dsa;

/**
 * Check if a number is a power of two using Brian Kernighan's algorithm.
 * 
 * PowerOfTwoBrianKernighanAlgo
 */

public class PowerOfTwoBrianKernighanAlgo {

    public static boolean isPowerOfTwo(int n) {
        // A number is a power of two if it has exactly one bit set in its binary representation.
        // The expression (n & (n - 1)) will be zero only for powers of two.
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        int[] testNumbers = {1, 2, 3, 4, 5, 8, 16, 31, 32, 64, 100};

        for (int num : testNumbers) {
            System.out.println(num + " is power of two? " + isPowerOfTwo(num));
        }
    }

}
