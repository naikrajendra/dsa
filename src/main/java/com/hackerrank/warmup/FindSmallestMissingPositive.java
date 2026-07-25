package com.hackerrank.warmup;

import java.util.ArrayList;
import java.util.List;

/**
 * Find the Smallest Missing Positive Integer
 * Given an array of integers, find the smallest positive integer that is
 * missing from the array.
 * Example
 * Input
 * orderNumbers = [3, 4, -1, 1]
 * Output 2
 * Explanation
 * The smallest missing positive integer is 2. Return 2.
 * 
 */

public class FindSmallestMissingPositive {

    public static int findSmallestMissingPositive(List<Integer> orderNumbers) {
        // Write your code here
        // Handle null or empty list edge case
        if (orderNumbers == null || orderNumbers.isEmpty()) {
            return 1;
        }

        // Operate in-place on the provided mutable list for O(1) extra space.
        List<Integer> numbers = orderNumbers;
        int n = numbers.size();

        // 1. Cyclic sort: Place each number at its correct index using set() and get()
        int i = 0;
        while (i < n) {
            int currentVal = numbers.get(i);
            int correctIndex = currentVal - 1;

            // Check boundaries and check if the target position already has this value
            if (currentVal > 0 && currentVal <= n && currentVal != numbers.get(correctIndex)) {
                // In-place swap using List operations
                int temp = numbers.get(correctIndex);
                numbers.set(correctIndex, currentVal);
                numbers.set(i, temp);
            } else {
                i++;
            }
        }

        // 2. Scan the list to find the first mismatch
        for (i = 0; i < n; i++) {
            if (numbers.get(i) != i + 1) {
                return i + 1;
            }
        }

        // 3. If all integers from 1 to n are present
        return n + 1;
    }

    public static void main(String[] args) {
        List<Integer> orderNumbers = new ArrayList<>(List.of(3, 4, -1, 1));
        System.out.println(findSmallestMissingPositive(orderNumbers));
    }

}
