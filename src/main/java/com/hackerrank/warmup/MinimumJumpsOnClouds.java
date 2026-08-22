package com.hackerrank.warmup;

import java.util.Arrays;
import java.util.List;

/**
 * Solution for the "Minimum Jumps on Clouds" problem.
 * MinimimJumpsOnClouds
 */

public class MinimumJumpsOnClouds {

    static int minimumJumpsOnClouds(List<Integer> c) {
        int n = c.size();
        int jumps = 0;
        int i = 0;

        while (i < n - 1) {
            // Try to make a jump of 2 if possible, otherwise jump 1
            if (i + 2 < n && c.get(i + 2) == 0) {
                i += 2;
            } else {
                i += 1;
            }
            jumps++;
        }

        return jumps;
    }

    public static void main(String[] args) {
        List<Integer> c = Arrays.asList(0, 0, 1, 0, 0, 1, 0);
        int result = minimumJumpsOnClouds(c);
        System.out.println(result); // Expected output: 4
    }

}
