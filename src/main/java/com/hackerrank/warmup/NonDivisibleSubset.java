package com.hackerrank.warmup;
import java.util.List;

/**
 * Given a set of integers, finds the size of the largest subset such that 
 * the sum of any two numbers is not divisible by a given integer k.
 * 
 * NonDivisibleSubset
 */

public class NonDivisibleSubset {

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Array to store frequency of each remainder
        int[] remainderCounts = new int[k];
        
        for (int num : s) {
            int remainder = num % k;
            // Handle potential negative remainders safely
            if (remainder < 0) {
                remainder += k;
            }
            remainderCounts[remainder]++;
        }
        
        // Count starts with max 1 element from remainder 0
        int maxSubsetSize = Math.min(remainderCounts[0], 1);
        
        // Loop through half of the remainders to pair them with complements
        for (int i = 1; i <= k / 2; i++) {
            if (i == k - i) {
                // Special case: middle remainder when k is even
                maxSubsetSize += Math.min(remainderCounts[i], 1);
            } else {
                // Pick the maximum count between remainder i and its complement
                maxSubsetSize += Math.max(remainderCounts[i], remainderCounts[k - i]);
            }
        }
        
        return maxSubsetSize;
    }

    public static void main(String[] args) {
        // Example usage
        List<Integer> s = List.of(1, 7, 2, 4);
        int k = 3;
        int result = nonDivisibleSubset(k, s);
        System.out.println(result);

    }
}
