package com.rpk.dsa;

/**
 * This code is a placeholder for the Sliding Window technique, which is commonly used to 
 * solve problems involving contiguous subarrays or substrings. 
 * The Sliding Window technique involves maintaining a window (a range of elements) 
 * that can expand and contract based on certain conditions. 
 * It is often used to optimize the time complexity of algorithms that would 
 * otherwise require nested loops.
 * The `SlidingWindowPointers` class is currently empty and can be implemented with
 *  methods that utilize the sliding window approach to solve specific problems.
 */

import java.util.HashSet;
import java.util.Set;

public class SlidingWindowPointers {

    /**
     * 1. Fixed Size Window
     * Finds the maximum sum of a subarray of size K.
     * Time Complexity: O(N) | Space Complexity: O(1)
     */
    public static int findMaxSumSubarray(int[] arr, int k) {
        if (arr == null || arr.length < k || k <= 0) {
            return 0;
        }

        int windowSum = 0;
        int maxSum = 0;

        // Calculate the sum of the first window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;

        // Slide the window across the rest of the array
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k]; // Add next element, remove first element of previous window
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    /**
     * 2. Dynamic Sized Window
     * Finds the length of the longest substring without repeating characters.
     * Time Complexity: O(N) | Space Complexity: O(Min(M, N)) where M is alphabet size
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Set<Character> seenCharacters = new HashSet<>();
        int maxLength = 0;
        int left = 0;

        // 'right' expands the window
        for (int right = 0; right < s.length(); right++) {
            // Shrink the window from 'left' if a duplicate is found
            while (seenCharacters.contains(s.charAt(right))) {
                seenCharacters.remove(s.charAt(left));
                left++;
            }
            // Add the new character and update max length
            seenCharacters.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    // Main method to verify the implementations
    public static void main(String[] args) {
        // Test Fixed Window
        int[] nums = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Max sum of subarray of size " + k + ": " + findMaxSumSubarray(nums, k)); // Expected: 9 (5+1+3)

        // Test Dynamic Window
        String text = "abcabcbb";
        System.out.println("Longest unique substring length: " + lengthOfLongestSubstring(text)); // Expected: 3 ("abc")
    }
}
