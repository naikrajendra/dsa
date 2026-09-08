package com.rpk.dsa.practice;

/**
 * Problem Statement:Given a 1-indexed array of integers numbers that is already 
 * sorted in non-decreasing order, find two numbers such that they add up to a 
 * specific target number. Return the indices of the two numbers, 
 * incremented by one, as an integer array [index1, index2] of size 2. 
 * You must solve this using only O(1) extra space. 
 * Example:Input: numbers = [2, 7, 11, 15], target = 9
 * Output: [1, 2] (Because 2 + 7 = 9, their 1-based indices are 1 and 2)
 * 
 * TwoSumII
 */

public class TwoSumII {

    public static int[] twoSum(int[] numbers, int target) {
       int left =0;
       int right = numbers.length - 1;
       int[] result = new int[2];
       
       while(left < right) {
            if(numbers[left] + numbers[right] == target) {
                result[0] = left;
                result[1] = right;
                return result;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left--;
            }
       }
       return result;
    }

    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        int[] res = twoSum(numbers,target);
        System.out.println("indices:" + res[0] + "," + res[1]);
    }
}
