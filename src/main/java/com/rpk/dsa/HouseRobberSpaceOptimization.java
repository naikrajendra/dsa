package com.rpk.dsa;

/**
 * House Robber problem with space optimization.
 * The `rob` method computes the maximum amount of money that can be robbed from a list of houses without robbing two adjacent houses. The time complexity of this approach is O(n), and the space complexity is O(1) due to the use of two variables to store the previous maximum values instead of an array.
 * Example usage is provided in the `main` method, which calculates and prints the maximum amount of money that can be robbed for given input arrays of house values.
 * 
 * 
 * HouseRobberSpaceOptimization
 */

public class HouseRobberSpaceOptimization {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int prev1 = 0;
        int prev2 = 0;
        for (int num : nums) {
            int temp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = temp;
        }
        return prev1;
    }

    public static void main(String[] args) {
        HouseRobberSpaceOptimization houseRobber = new HouseRobberSpaceOptimization();
        int[] nums1 = {1, 2, 3, 1};
        System.out.println(houseRobber.rob(nums1)); // Output: 4

        int[] nums2 = {2, 7, 9, 3, 1};
        System.out.println(houseRobber.rob(nums2)); // Output: 12
    }

}
