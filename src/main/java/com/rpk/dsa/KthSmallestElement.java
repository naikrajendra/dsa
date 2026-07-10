package com.rpk.dsa;

/**
 * This class provides methods to find the k-th smallest element in an array.
 * The `findKthSmallest` method sorts the array and retrieves the k-th smallest 
 * element directly.
 * The `findKthSmallestUsingHeap` method uses a max-heap (priority queue) to 
 * efficiently find the k-th smallest element without fully sorting the array.
 * The heap-based approach maintains a heap of size k, ensuring that the largest 
 * element in the heap is the k-th smallest element in the array.
 * Both methods have their own time complexities: the sorting method has a  
 * time complexity of O(n log n), while the heap-based method has a 
 * time complexity of O(n log k), making it more efficient for large arrays
 * KthSmallestElement
 */

public class KthSmallestElement {

    public int findKthSmallest(int[] nums, int k) {
        // Sort the array in ascending order
        java.util.Arrays.sort(nums);
        // Return the k-th smallest element
        return nums[k - 1];
    }

    public int findKthSmallestUsingHeap(int[] nums, int k) {
        // Create a max-heap with a capacity of k
        java.util.PriorityQueue<Integer> maxHeap = new java.util.PriorityQueue<>((a, b) -> b - a);
        // Add the first k elements to the heap
        for (int i = 0; i < k; i++) {
            maxHeap.offer(nums[i]);
        }
        // Process the remaining elements
        for (int i = k; i < nums.length; i++) {
            if (nums[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(nums[i]);
            }
        }
        // Return the root of the heap (the k-th smallest element)
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        KthSmallestElement kthSmallest = new KthSmallestElement();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int result = kthSmallest.findKthSmallest(nums, k);
        System.out.println("The " + k + "-th smallest element is: " + result); // Output: 2
        int resultHeap = kthSmallest.findKthSmallestUsingHeap(nums, k);
        System.out.println("The " + k + "-th smallest element using heap is: " + resultHeap); // Output: 2
    }
}
