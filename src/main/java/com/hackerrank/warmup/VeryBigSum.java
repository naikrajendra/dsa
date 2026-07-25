package com.hackerrank.warmup;

public class VeryBigSum {

    public static void main(String[] args) {
        // Sample input data for the array of integers
        long[] arr = { 1000000001, 1000000002, 1000000003, 1000000004, 1000000005 };

        long result = aVeryBigSum(arr);
        System.out.println("The sum of the array elements is: " + result);
    }

    public static long aVeryBigSum(long[] arr) {
        long sum = 0;
        for (long num : arr) {
            sum += num;
        }
        return sum;
    }

}
