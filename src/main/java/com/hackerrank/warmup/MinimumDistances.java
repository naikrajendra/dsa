package com.hackerrank.warmup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Finds the minimum distance between equal elements in a list of integers.
 * Returns -1 if no such elements exist.
 * MinimumDistances
 */
public class MinimumDistances {

    public static int minimumDistances(List<Integer> a) {
        // Write your code here
        //
        int minimumDistances = -1;
        int len = 0;
        if (a != null && a.size() > 0) {
            len = a.size(); // 5
        }
        // 3,2,1,2,3
        // 7 1 3 4 1 7
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (a.get(i).equals(a.get(j))) { // 7==2, 3==1, 3==2,3==3
                    if (minimumDistances < 0)
                        minimumDistances = (j - i);
                    else
                        minimumDistances = Math.min(minimumDistances, (j - i)); // 4
                }
            }
        }

        return minimumDistances;

    }

    public static int minimumDistancesOptimized(List<Integer> a) {
        // Stores the number as the key, and its most recent index as the value
        Map<Integer, Integer> map = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < a.size(); i++) {
            int num = a.get(i);

            if (map.containsKey(num)) {
                // Calculate distance from the last time we saw this number
                int distance = i - map.get(num);
                minDistance = Math.min(minDistance, distance);
            }

            // Always update to the latest index to get the minimum distance
            map.put(num, i);
        }

        // If minDistance was never updated, return -1
        return (minDistance == Integer.MAX_VALUE) ? -1 : minDistance;
    }

    public static void main(String[] args) {
        List<Integer> a = List.of(7, 1, 3, 4, 1, 7);
        int result = minimumDistances(a);
        System.out.println(result);
    }
}
