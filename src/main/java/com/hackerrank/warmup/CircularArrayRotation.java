package com.hackerrank.warmup;

import java.util.ArrayList;
import java.util.List;

/**
 * CircularArrayRotation
 *
 * This class provides a method to perform circular array rotation
 * and answer queries about the rotated array efficiently.
 *  
 */

public class CircularArrayRotation {
    /*
     * Complete the 'circularArrayRotation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER k
     *  3. INTEGER_ARRAY queries
     */
    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
        List<Integer> finalList = new ArrayList<>();
        int n = a.size();
        
        // Reduce k in case it is larger than the size of the array
        int effectiveRotation = k % n; 

        // Answer each query in O(1) time
        for (int queryIndex : queries) {
            // Find which index from the original array 'a' maps to the queried index
            int originalIndex = (queryIndex - effectiveRotation + n) % n;
            finalList.add(a.get(originalIndex));
        }
        
        return finalList;
    }

    public static void main(String[] args) {
        List<Integer> a = List.of(1, 2, 3);
        int k = 2;
        List<Integer> queries = List.of(0, 1, 2);
        
        List<Integer> result = circularArrayRotation(a, k, queries);
        System.out.println(result); // Expected output: [2, 3, 1]
    }
}
