package com.hackerrank.warmup;

/**
 * SaveThePrisoner
 *
 * This class contains a method to determine which prisoner will receive the last candy.
 */


public class SaveThePrisoner {
    /*
     * Complete the 'saveThePrisoner' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. INTEGER s
     */

    public static int saveThePrisoner(int n, int m, int s) {
        // Calculate the raw position, then map it to a 1-indexed chair
        int prisoner = (s + m - 1) % n;
        
        // If the remainder is 0, it means the last chair (n) gets the candy
        return (prisoner == 0) ? n : prisoner;
    }

    public static void main(String[] args) {
        int n = 5; // number of prisoners
        int m = 2; // number of candies
        int s = 1; // starting chair
        int result = saveThePrisoner(n, m, s);
        System.out.println(result); // Expected output: 2
    }

}
