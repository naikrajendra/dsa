package com.rpk.dsa;

/**
 * This class provides a method to determine if there exists a subset of the given array that sums up to a specified target value using a backtracking approach.
 * The `canPartition` method initiates the backtracking process, while the `backtrack` method explores all possible combinations of the array elements to find a subset that meets the target sum. The time complexity of this approach is O(2^n) in the worst case, where n is the number of elements in the array, due to the exploration of all subsets. The space complexity is O(n) for the recursion stack.
 * Example usage is provided in the `main` method, which checks for the existence of a subset that sums to a given target value and prints the result.  
 * 
 * BackTrackDPSubset
 */

public class BackTrackDPSubset {

 public boolean canPartition(int[] nums, int target) {
        // Start recursion from index 0 with an initial sum of 0
        return backtrack(nums, target, 0, 0);
    }

    private boolean backtrack(int[] nums, int target, int index, int currentSum) {
        // Base Case 1: Target sum found
        if (currentSum == target) {
            return true;
        }

        // Base Case 2: Out of bounds or current sum exceeded target (for positive numbers)
        if (index >= nums.length || currentSum > target) {
            return false;
        }

        // Decision 1: Include the current element in the subset
        if (backtrack(nums, target, index + 1, currentSum + nums[index])) {
            return true;
        }

        // Decision 2: Exclude the current element from the subset
        if (backtrack(nums, target, index + 1, currentSum)) {
            return true;
        }

        // Neither decision led to the target sum
        return false;
    }

    public static void main(String[] args) {
        BackTrackDPSubset solver = new BackTrackDPSubset();
        int[] nums = {3, 34, 4, 12, 5, 2};
        int target = 9;
        
        boolean exists = solver.canPartition(nums, target);
        System.out.println("Subset with target sum exists: " + exists);
    }

}
