package com.rpk.dsa.practice;

/**
 * Problem Statement:Given an integer array nums, move all 0s to the end of it while maintaining the relative order of the non-zero elements. 
 * You must do this in-place without making a copy of the array.
 * Example:Input: nums = [0, 1, 0, 3, 12]
 * Output: [1, 3, 12, 0, 0]
 */

public class MoveZeroes {

    public static int[] moveZeroes(int[] nums) {
        int insertPos = 0; // Pointer tracking the position for the next non-zero element

        for (int i = 0; i < nums.length; i++) {
            // When we find a non-zero element, swap it with the element at insertPos
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[insertPos];
                nums[insertPos] = temp;
                
                insertPos++; // Move the insert pointer forward
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        nums = moveZeroes(nums);
        for(int i:nums) {
            System.out.println(i);
        }

    }

}
