package com.hackerrank.warmup;

import java.util.*;

/**
 * 
 * PlusMinusElements
 * Given an array of integers, calculate the ratios of its elements that are , ,
 * and . Print the decimal value of each fraction on a new line with 6 places
 * after the decimal.
 * Note: This challenge introduces precision problems. The test cases are scaled
 * to six decimal places, though answers with absolute error of up to are
 * acceptable.
 * Example
 *
 * There are elements: two positive, two negative and one zero.
 * Their ratios are , and . Results are printed as:
 *
 * 0.400000
 * 0.400000
 * 0.200000
 */

class PlusMinusElements {
    public static void plusMinus(List<Integer> arr) {
        int pos = 0, neg = 0, zero = 0;
        for (int n : arr) {
            if (n > 0)
                pos++;
            else if (n < 0)
                neg++;
            else
                zero++;
        }
        int total = arr.size();
        System.out.printf("%.6f%n", (double) pos / total);
        System.out.printf("%.6f%n", (double) neg / total);
        System.out.printf("%.6f%n", (double) zero / total);
    }

    public static void main(String[] args) {
        plusMinus(Arrays.asList(-4, 3, -9, 0, 4, 1));
        System.out.println("---");
        plusMinus(Arrays.asList(1, 2, 3));
        System.out.println("---");
        plusMinus(Arrays.asList(-1, -2, -3));
    }
}
