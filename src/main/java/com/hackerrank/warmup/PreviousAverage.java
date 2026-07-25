package com.hackerrank.warmup;

import java.util.List;

/**
 * Previous Average
 * Given an array of positive integers, return the number of elements that are
 * strictly greater than the average of all previous elements. Skip the first
 * element.
 * Example
 * 
 * Input
 * 
 * responseTimes = [100, 200, 150,300]
 * Output 2
 * Explanation
 * 
 * - Day 0: 100 (no previous days, skip)
 * - Day 1: 200 > average(100) = 100 → count = 1
 * - Day 2: 150 vs average(100, 200) = 150 → not greater → count = 1
 * - Day 3: 300 > average(100, 200, 150) = 150 → count = 2 Return 2.
 * 
 */

public class PreviousAverage {

    public static int countResponseTimeRegressions(List<Integer> responseTimes) {
        // Write your code here
        // Return 0 if the list is null or contains 1 or fewer elements
        if (responseTimes == null || responseTimes.size() <= 1) {
            return 0;
        }

        int count = 0;
        // Use long to prevent integer overflow during summation
        long runningSum = responseTimes.get(0);

        for (int i = 1; i < responseTimes.size(); i++) {
            long currentVal = responseTimes.get(i);

            // Integer-safe comparison equivalent to: currentVal > (runningSum / i)
            if (currentVal * i > runningSum) {
                count++;
            }

            // Add current value to the running total for the next iterations
            runningSum += currentVal;
        }

        return count;
    }

    public static void main(String[] args) {
        List<Integer> responseTimes = List.of(100, 200, 150, 300);
        System.out.println(countResponseTimeRegressions(responseTimes));
    }

}
