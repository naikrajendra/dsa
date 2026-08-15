package com.hackerrank.warmup;

import java.math.BigInteger;

/**
 * Solution for the "Extra Long Factorials" problem.
 * 
 * ExtraLongFactorial
 */

public class ExtraLongFactorial {

    public static void extraLongFactorials(int n) {
    // Write your code here
        BigInteger extraLongFactorial = BigInteger.ONE;
        
        while(n > 0) {
            extraLongFactorial = extraLongFactorial.multiply(BigInteger.valueOf(n));
            n = n - 1;
        }
        System.out.println(extraLongFactorial);
    }

    public static void main(String[] args) {
        int n = 25; // Example input
        extraLongFactorials(n); // Expected output: 15511210043330985984000000
    }
}
