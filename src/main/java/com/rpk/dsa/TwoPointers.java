package com.rpk.dsa;
/**
 * This code implements the Two Pointers technique to solve the Two Sum problem.
 * The `twoSum` method takes a sorted array of integers and a target sum as input,
 * and returns the 1-based indices of the two numbers that add up to the target.
 * The algorithm uses two pointers, one starting at the beginning of the array (left)
 * and the other starting at the end of the array (right). It iteratively checks
 * the sum of the numbers at these pointers and adjusts the pointers accordingly
 * until it finds the target sum or determines that no solution exists.
 */

public class TwoPointers {

    /*
     * Finds the indices of two numbers in a sorted array that add up to a target sum.
     * @param numbers The sorted array of integers.
     * @param target The target sum.
     * @return An array containing the 1-based indices of the two numbers, or [-1, -1] if no solution is found.
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1}; // Return 1-based indices
            } else if (sum < target) {
                left++; // Move left pointer to the right
            } else {
                right--; // Move right pointer to the left
            }
        }

        return new int[]{-1, -1}; // Return -1 if no solution is found
    }

    public static void main(String[] args) {
        TwoPointers solution = new TwoPointers();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(numbers, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]); // Output: Indices: 1, 2
    }

}
