package com.hackerrank.warmup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Solution for the "Cut the Sticks" problem.
 * CutTheSticks
 */

public class CutTheSticks {
    
    /**
     * Solution for the "Cut the Sticks" problem.
     * @param arr List of stick lengths.
     * @return List of the number of sticks before each cut.
     */
    public static List<Integer> cutTheSticks(List<Integer> arr) {
        List<Integer> result = new ArrayList<>();
        Collections.sort(arr);

        int n = arr.size();
        if (n == 0)
            return result;

        result.add(n);
        for (int i = 1; i < n; i++) {
            if (!arr.get(i).equals(arr.get(i - 1))) {
                result.add(n - i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(1);
        arr.add(2);
        arr.add(1);
        arr.add(3);

        List<Integer> result = cutTheSticks(arr);
        System.out.println(result); // Expected output: [5, 4, 2, 1]
    }

}
