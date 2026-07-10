package com.rpk.dsa;

/**
 * This class provides methods to find the k-th largest element in an array.
 * The `findKthLargest` method sorts the array and retrieves the k-th largest element directly.
 * The `findKthLargestUsingHeap` method uses a min-heap (priority queue) to efficiently find the k-th largest element without fully sorting the array.
 * The heap-based approach maintains a heap of size k, ensuring that the smallest element in the heap is the k-th largest element in the array.
 * Both methods have their own time complexities: the sorting method has a 
 * time complexity of O(n   log n), while the heap-based method has a 
 * time complexity of O(n log k), making it more efficient for large arrays 
 * when k is much smaller than n.   
 * 
 */

public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        // Sort the array in descending order
        java.util.Arrays.sort(nums);
        // Return the k-th largest element
        return nums[nums.length - k];
    }

    public int findKthLargestUsingHeap(int[] nums, int k) {
        // Create a min-heap with a capacity of k
        java.util.PriorityQueue<Integer> minHeap = new java.util.PriorityQueue<>();
        // Add the first k elements to the heap
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }
        // Process the remaining elements
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        // Return the root of the heap (the k-th largest element)
        return minHeap.peek();
    }


    //main method to test the findKthLargest function
    public static void main(String[] args) {
        KthLargestElement kthLargest = new KthLargestElement();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int result = kthLargest.findKthLargest(nums, k);
        System.out.println("The " + k + "-th largest element is: " + result); // Output: 5
        int resultHeap = kthLargest.findKthLargestUsingHeap(nums, k);
        System.out.println("The " + k + "-th largest element using heap is: " + resultHeap); // Output: 5
    }


}
