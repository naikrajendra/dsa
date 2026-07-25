package com.hackerrank.warmup;

import java.util.*;

/**
 * Given five positive integers, find the minimum and maximum values that can be
 * calculated by summing exactly four of the five integers. Then print the
 * respective minimum and maximum values as a single line of two space-separated
 * long integers.
 *
 * Example:
 * The minimum sum is and the maximum sum is . The function prints
 * 16 24
 *
 * Function Description:
 * Complete the miniMaxSum function in the editor below.
 *
 * miniMaxSum has the following parameter(s):
 * arr: an array of 5 integers
 *
 * Print:
 * Print two space-separated integers on one line: the minimum sum and the
 * maximum sum of 4 of 5 elements.
 *
 * Input Format:
 * A single line of five space-separated integers.
 *
 * Constraints:
 *
 * Output Format:
 * Print two space-separated long integers denoting the respective minimum and
 * maximum values that can be calculated by summing exactly four of the five
 * integers. (The output can be greater than a 32-bit integer.)
 *
 * Sample Input:
 * 1 2 3 4 5
 * Sample Output:
 * 10 14
 *
 * Explanation:
 * The numbers are , , , , and . Calculate the following sums using four
 * of the five integers:
 * Sum everything except , the sum is .
 * Sum everything except , the sum is .
 * Sum everything except , the sum is .
 * Sum everything except , the sum is .
 * Sum everything except , the sum is .
 *
 * Hints: Beware of integer overflow! Use 64-bit Integer.
 */
public class MiniMaxSum {

    /**
     * Compute the minimum and maximum sum by excluding the largest and smallest
     * value.
     *
     * @param arr a list of exactly five integers
     */
    public static void miniMaxSum(List<Integer> arr) {
        if (arr == null || arr.size() != 5) {
            return;
        }

        long total = 0;
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for (int value : arr) {
            total += value;
            minValue = Math.min(minValue, value);
            maxValue = Math.max(maxValue, value);
        }

        long minSum = total - maxValue;
        long maxSum = total - minValue;

        System.out.println(minSum + " " + maxSum);
    }

    private static void runTest(String title, List<Integer> arr, String expected) {
        System.out.println("\n" + title);
        System.out.println("Input: " + arr);
        System.out.print("Output: ");
        miniMaxSum(arr);
        System.out.println("Expected: " + expected);
    }

    public static void main(String[] args) {
        runTest("Test 1: Example", Arrays.asList(1, 2, 3, 4, 5), "10 14");
        runTest("Test 2: Duplicate values", Arrays.asList(5, 5, 5, 5, 5), "20 20");
        runTest("Test 3: Mixed negative and positive", Arrays.asList(-1, 0, 1, 2, 3), "5 6");
        runTest("Test 4: Large values", Arrays.asList(1000000000, 1000000000, 1000000000, 1000000000, 1000000000),
                "4000000000 4000000000");
    }
}
