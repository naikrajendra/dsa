package com.hackerrank.warmup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of the BigSorting problem.
 * The task is to sort a list of large numbers represented as strings.
 * Numbers are compared first by their length and then lexicographically if lengths are equal.
 * Example:
 * Input: ["3", "123", "45", "6", "7890"]
 * Output: ["3", "6", "45", "123", "7890"]
 * The function bigSorting(List<String> unsorted) implements this logic efficiently.
 * Time Complexity: O(n log n) where n is the number of elements in the list.
 * Space Complexity: O(n) due to the creation of a new list for sorting.
 *
 * Author: Rajendra Naik
 *
 * BigSorting
 */

public class BigSorting {

    public static List<String> bigSorting(List<String> unsorted) {
        List<String> sorted = new ArrayList<>(unsorted);

        Collections.sort(sorted, (string1, string2) -> {
            if (string1.length() != string2.length()) {
                return Integer.compare(string1.length(), string2.length());
            }
            return string1.compareTo(string2);
        });

        return sorted;
    }

    public static void main(String[] args) {
        List<String> unsorted = List.of("3", "123", "45", "6", "7890");
        List<String> sorted = bigSorting(unsorted);
        for (String s : sorted) {
            System.out.println(s);
        }
    }
}
