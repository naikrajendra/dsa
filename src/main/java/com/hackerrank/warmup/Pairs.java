package com.hackerrank.warmup;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pairs {

    /**
     * Brute force approach to find the number of pairs with a given difference.
     * Doesnt work
     * 
     * @param k
     * @param arr
     * @return
     */
    /*
     * public static int pairs(int k, List<Integer> arr) {
     * // Write your code here
     * int pairsCount = 0;
     * if (arr == null || arr.size() < 1) return 0;
     * for(int i=0; i < arr.size(); i++) {
     * int iElem = arr.get(i);
     * 
     * for(int j = i+1; j < arr.size(); j++) {
     * int jElem = arr.get(j);
     * int diff = iElem - jElem;
     * diff = Math.abs(diff);
     * if(diff == k) {
     * pairsCount = pairsCount + 1;
     * }
     * }
     * }
     * return pairsCount;
     * }
     */
    // Optimized approach using a HashSet to find pairs with a given difference.
    // This approach has a time complexity of O(n) and space complexity of O(n).
    public static int pairs(int k, List<Integer> arr) {
        if (arr == null || arr.size() < 2) {
            return 0;
        }

        int pairsCount = 0;
        Set<Integer> set = new HashSet<>(arr);
        // Iterate through the set and check if the complement (num + k) exists in the
        // set
        // This ensures we only count unique pairs and avoid counting the same pair
        // twice
        // For example, if we have a pair (num, num + k), we will only count it when we
        // encounter 'num' in the set
        // k = A- B; B = A - k; A = B + k; So we check if num + k exists in the set to
        // find the pair (num, num + k)
        for (int num : set) {
            if (set.contains(num + k)) {
                pairsCount++;
            }
        }

        return pairsCount;
    }
}
