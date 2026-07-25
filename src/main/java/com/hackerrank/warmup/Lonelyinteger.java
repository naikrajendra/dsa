package com.hackerrank.warmup;

import java.util.List;

/**
 * Given an array of integers, where all elements but one occur twice, find the
 * unique element.
 * Example
 * a = [1, 2, 3, 4, 3, 2, 1]
 * The unique element is 4.
 */

public class Lonelyinteger {

    public static int lonelyinteger(List<Integer> a) {
        // Write your code here
        int unique = 0;
        if (a != null && a.size() > 0) {
            for (int elem : a) {
                unique ^= elem;
            }
        }
        return unique;
    }

    public static void main(String[] args) {
        List<Integer> test1 = List.of(1, 2, 3, 4, 3, 2, 1);
        System.out.println("Test 1: " + (lonelyinteger(test1) == 4 ? "PASS" : "FAIL"));

        List<Integer> test2 = List.of(7, 3, 5, 4, 5, 3, 4);
        System.out.println("Test 2: " + (lonelyinteger(test2) == 7 ? "PASS" : "FAIL"));

        List<Integer> test3 = List.of(1);
        System.out.println("Test 3: " + (lonelyinteger(test3) == 1 ? "PASS" : "FAIL"));

        List<Integer> test4 = List.of(0, 0, -1);
        System.out.println("Test 4: " + (lonelyinteger(test4) == -1 ? "PASS" : "FAIL"));
    }

}
