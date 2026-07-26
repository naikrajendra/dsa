package com.rpk.dsa.practice;

import java.util.HashMap;

/**
 * TwoSum problem solution.
 * Given an array of integers nums and an integer target, return the indices of the
 * two numbers such that they add up to target.You may assume that each input would have exactly one solution, and you may not use the same element twice. You can return the answer in any order.
 * Examples:
 * Example 1:
 * Input: nums = [2, 7, 11, 15], target = 9
 * Output: [0, 1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 * Input: nums = [3, 2, 4], target = 6
 * Output: [1, 2]
 * Explanation: Because nums[1] + nums[2] == 6, we return [1, 2].
 * Example 3:
 * Input: nums = [3, 3], target = 6
 * Output: [0, 1]
 */

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        // Map to store: Key = Number Value, Value = Its Original Index
        HashMap<Integer, Integer> seen = new HashMap<>();
        //{2,7,11,15} target 9

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // complement 7 2
            // target 9
            // nums[i] 2 7  
            // If we already saw the complement, we found our pair!
            if (seen.containsKey(complement)) {
                return new int[] { seen.get(complement), i };
                // 0, 1
            }
            
            // Otherwise, remember this number and its index for later
            seen.put(nums[i], i);
            // seen [2, 0]
        }
        
        return new int[] {-1, -1}; // Fallback if no solution exists

    }

    public static void main(String args[]) {
        int nums[] = {2,7,11,15};
        int target = 9;
        int[] res = twoSum(nums,target);
        System.out.println(res[0] + " " + res[1]);
        int[] nums1 = {3,2,4};
        int target1 = 6;
        int res1[] = twoSum(nums1,target1);
        System.out.println(res1[0] + " " + res1[1]);
    }
}
