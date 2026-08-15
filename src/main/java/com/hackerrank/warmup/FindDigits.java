package com.hackerrank.warmup;

/**
 * Solution for the "Find Digits" problem.
 * 
 * FindDigits
 */

public class FindDigits {
    public static int findDigits(int n) {
        // Write your code here
        //loop to find each divisor digit d
        //find if n%d==0
        int n1 = n;
        int digits = 0;
        //1012,101
        while(n > 0) {
            int div = n%10;//2,1,1
            if(div!=0 && n1%div ==0) digits++; //1,2,3
            n = n / 10;//101,10,1
        }
        return digits;
    }

    public static void main(String[] args) {
        int n = 1012; // Example input
        int result = findDigits(n);
        System.out.println(result); // Expected output: 3
    }

}
