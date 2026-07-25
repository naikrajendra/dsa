package com.hackerrank.warmup;

import java.util.Arrays;
import java.util.List;

public class MedianCalculatorList {

    public static int findMedian(List<Integer> numArray) {
        if (numArray == null || numArray.isEmpty()) {
            throw new IllegalArgumentException("Array cannot be empty or null");
        }

        // Convert List<Integer> to a sorted primitive int[] array
        /*
         * int[] sortedArray = numArray.stream()
         * .mapToInt(Integer::intValue)
         * .sorted()
         * .toArray();
         */
        int[] sortedArray = numArray.stream().mapToInt(Integer::intValue).sorted().toArray();
        int totalElements = sortedArray.length;

        if (totalElements % 2 != 0) {
            // Odd length: return the exact center element
            return sortedArray[totalElements / 2];
        } else {
            // Even length: integer division truncates the decimal (.5)
            int midIndex1 = totalElements / 2;
            int midIndex2 = midIndex1 - 1;
            return (sortedArray[midIndex1] + sortedArray[midIndex2]) / 2;
        }
    }

    public static void main(String[] args) {
        // Your input array represented as a List<Integer>
        List<Integer> evenList = Arrays.asList(10, 2, 38, 22, 38, 23);

        int median = findMedian(evenList);

        System.out.println("Median (int): " + median);
        // Sorted: [2, 10, 22, 23, 38, 38] -> (22 + 23) / 2 = 22

        System.out.println("Original list remains unchanged: " + evenList);
    }
}
