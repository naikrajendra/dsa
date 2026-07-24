package com.rpk.dsa;

/**
 * This class implements a solution to the Jump Game II problem using a greedy algorithm approach. The `JumpGameIIGreedyAlgorithm` class includes the following method:
 * - `jump(int[] nums)`: Determines the minimum number of jumps required to reach the last index of the given array `nums`, where each element in the array represents the maximum jump length from that position. The method returns the minimum number of jumps needed to reach the last index.
 * The greedy algorithm works by maintaining two variables: `currentEnd`, which represents the farthest index that can be reached with the current number of jumps, and `farthest`, which represents the farthest index that can be reached with the next jump. As we iterate through the array, we update `farthest` to keep track of the maximum reachable index. When we reach `currentEnd`, we increment the jump count and update `currentEnd` to `farthest`. This process continues until we reach or exceed the last index of the array.
 * Example usage: 
 * JumpGameIIGreedyAlgorithm jumpGameII = new JumpGameIIGreedyAlgorithm();
 * int[] nums1 = {2, 3, 1, 1, 4};
 * System.out.println(jumpGameII.jump(nums1)); // Output: 2
 * int[] nums2 = {2, 3, 0, 1, 4};
 * System.out.println(jumpGameII.jump(nums2)); // Output: 2
 * 
 * JumpGameIIGreedyAlgorithm
 */

public class JumpGameIIGreedyAlgorithm {

    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;

                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
        JumpGameIIGreedyAlgorithm jumpGameII = new JumpGameIIGreedyAlgorithm();
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println(jumpGameII.jump(nums1)); // Output: 2

        int[] nums2 = {2, 3, 0, 1, 4};
        System.out.println(jumpGameII.jump(nums2)); // Output: 2
    }


}
