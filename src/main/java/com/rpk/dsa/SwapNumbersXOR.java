package com.rpk.dsa;

/***
 * Swap two numbers in an array using XOR bitwise operation.
 * The array must contain exactly two numbers.
 * 
 */

public class SwapNumbersXOR {

    public static void swapNumbers(int[] nums) {
        if (nums == null || nums.length != 2) {
            throw new IllegalArgumentException("Input array must contain exactly two numbers.");
        }

        // XOR swap algorithm
        nums[0] = nums[0] ^ nums[1];
        nums[1] = nums[0] ^ nums[1];
        nums[0] = nums[0] ^ nums[1];
    }

    public static void main(String[] args) {
        int[] nums = {105, 10};
        System.out.println("Before swap: " + nums[0] + ", " + nums[1]);
        swapNumbers(nums);
        System.out.println("After swap: " + nums[0] + ", " + nums[1]);
    }

}
