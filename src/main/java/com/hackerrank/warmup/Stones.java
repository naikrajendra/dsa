package com.hackerrank.warmup;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * This class contains a method to calculate all possible values of the last stone
 * in a sequence where each step can be either 'a' or 'b'. It also includes a main
 * method to demonstrate the usage of the stones method.
 * 
 * Stones
 */

public class Stones {

    public static List<Integer> stones(int n, int a, int b) {
        // Use a TreeSet to keep elements sorted and remove duplicates
        SortedSet<Integer> uniqueOutputs = new TreeSet<>();

        // There are n-1 total steps to reach the last stone
        int steps = n - 1;

        // Iterate through all possible combinations of taking step 'b' vs step 'a'
        for (int i = 0; i <= steps; i++) {
            int finalValue = (i * b) + ((steps - i) * a);
            uniqueOutputs.add(finalValue);
        }

        // Convert the sorted set back into a List as required by the return type
        return new ArrayList<>(uniqueOutputs);
    }

    public static void main(String[] args) {
        int n = 5;
        int a = 3;
        int b = 4;
        List<Integer> result = stones(n, a, b);
        for (int value : result) {
            System.out.println(value);
        }
    }
}