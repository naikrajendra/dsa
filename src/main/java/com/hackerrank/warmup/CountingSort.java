package com.hackerrank.warmup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountingSort {

    /*
     * Complete the 'countingSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        // 1. Create a frequency list of exactly 100 elements initialized to 0
        List<Integer> frequencyList = new ArrayList<>(Collections.nCopies(100, 0));

        // 2. Iterate through the input and increment the frequency counter
        for (int num : arr) {
            int currentCount = frequencyList.get(num);
            frequencyList.set(num, currentCount + 1);
        }

        // 3. Return the 100-element frequency tracking list
        return frequencyList;
    }

    // main method is not required for the HackerRank submission, but you can use it
    // for local testing
    public static void main(String[] args) {
        List<Integer> input = List.of(1, 1, 3, 2, 1);
        List<Integer> result = countingSort(input);
        System.out.println(result); // Expected output: [0, 3, 1, 1, 0, ..., 0] (100 elements total)
    }
}
