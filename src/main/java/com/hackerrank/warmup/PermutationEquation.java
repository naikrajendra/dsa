package com.hackerrank.warmup;

import java.util.List;
import java.util.ArrayList;

/**
 * PermutationEquation
 *
 * This class provides a method to solve the permutation equation problem.
 */

public class PermutationEquation {

    /*
     * Complete the 'permutationEquation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY p as parameter.
     */

    public static List<Integer> permutationEquation(List<Integer> p) {
        int n = p.size();
        List<Integer> result = new ArrayList<>();

        // Create an array to store the position of each value in p
        int[] position = new int[n + 1];
        for (int i = 0; i < n; i++) {
            position[p.get(i)] = i + 1; // Store 1-indexed positions
        }

        // For each x from 1 to n, find y such that p(p(y)) = x
        for (int x = 1; x <= n; x++) {
            int y = position[x]; // Find the position of x in p
            result.add(position[y]); // Find the position of y in p
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> p = List.of(5, 2, 1, 3, 4);
        List<Integer> result = permutationEquation(p);

        for (int value : result) {
            System.out.println(value); // Expected output: [4, 2, 5, 1, 3]
        }
    }

}
