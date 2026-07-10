package com.rpk.dsa;

/**
 * This class provides a method to find the k most frequent elements in an array.
 * The `topKFrequent` method uses a HashMap to count the frequency of each element 
 * and a min-heap (priority queue) to efficiently retrieve the k most frequent elements.
 * The method maintains a heap of size k, ensuring that the least frequent element 
 * in the heap is removed when a more frequent element is encountered.
 * The time complexity of this approach is O(n log k), where n is the number of 
 * elements in the input array and k is the number of most frequent elements to return. 
 * This makes it efficient for large arrays when k is much smaller than n.        
 * 
 * TopKFrequencyElements
 */

public class TopKFrequencyElements {

    public int[] topKFrequent(int[] nums, int k) {
        java.util.HashMap<Integer, Integer> frequencyMap = new java.util.HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        java.util.PriorityQueue<java.util.Map.Entry<Integer, Integer>> minHeap =
                new java.util.PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (java.util.Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        TopKFrequencyElements topK = new TopKFrequencyElements();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = topK.topKFrequent(nums, k);
        System.out.print("The " + k + " most frequent elements are: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
