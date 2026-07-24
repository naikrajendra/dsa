package com.rpk.dsa;

/**
 * This class implements a solution to the Jump Game I problem using a greedy algorithm approach. The `JumpGameIGreedyAlgorithm` class includes the following method:
 * - `canJump(int[] nums)`: Determines if it is possible to reach the last index of the given array `nums`, where each element in the array represents the maximum jump length from that position. The method returns `true` if it is possible to reach the last index, otherwise it returns `false`.
 * The greedy algorithm works by maintaining a variable `maxReach` that keeps track of the far thest index that can be reached at any point during the iteration through the array. If at any index `i`, the current index exceeds `maxReach`, it means that it is not possible to reach the last index, and the method returns `false`. Otherwise, if the loop completes, it indicates that reaching the last index is possible, and the method returns `true`.
 * Example usage:
 * JumpGameIGreedyAlgorithm jumpGame = new JumpGameIGreedyAlgorithm();
 * int[] nums1 = {2, 3, 1, 1, 4};
 * System.out.println(jumpGame.canJump(nums1)); // Output: true 
 * int[] nums2 = {3, 2, 1, 0, 4};
 * System.out.println(jumpGame.canJump(nums2)); // Output: false    
 * 
 * JumpGameIGreedyAlgorithm
 */

public class JumpGameIGreedyAlgorithm {

    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        JumpGameIGreedyAlgorithm jumpGame = new JumpGameIGreedyAlgorithm();
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println(jumpGame.canJump(nums1)); // Output: true

        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(jumpGame.canJump(nums2)); // Output: false
    }


}
