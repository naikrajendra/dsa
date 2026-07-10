package com.rpk.dsa;

/**
 * This class provides a method to find the k pairs with the smallest sums from two 
 * sorted arrays.
 * The `kSmallestPairs` method uses a max-heap (priority queue) to efficiently 
 * find the k pairs with the smallest sums.
 * The method iterates through the first k elements of both arrays, adding pairs 
 * to the heap and maintaining the size of the heap to k.
 * The time complexity of this approach is O(k log k), where k is the number of 
 * pairs to return. This makes it efficient for finding the smallest pairs when k 
 * is much smaller than the total number of possible pairs. 
 * 
 * FindkPairsWithSmallestSum
 */

public class FindkPairsWithSmallestSum {

    public int[][] kSmallestPairs(int[] nums1, int[] nums2, int k) {
        java.util.PriorityQueue<int[]> maxHeap = new java.util.PriorityQueue<>((a, b) -> (b[0] + b[1]) - (a[0] + a[1]));

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            for (int j = 0; j < Math.min(nums2.length, k); j++) {
                maxHeap.offer(new int[]{nums1[i], nums2[j]});
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }

        int[][] result = new int[maxHeap.size()][2];
        for (int i = maxHeap.size() - 1; i >= 0; i--) {
            result[i] = maxHeap.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        FindkPairsWithSmallestSum finder = new FindkPairsWithSmallestSum();
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        int[][] result = finder.kSmallestPairs(nums1, nums2, k);
        System.out.println("The " + k + " pairs with the smallest sums are:");
        for (int[] pair : result) {
            System.out.println("[" + pair[0] + ", " + pair[1] + "]");
        }
    }

}
