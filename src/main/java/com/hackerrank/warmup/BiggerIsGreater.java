package com.hackerrank.warmup;

/**
 * Finds the next lexicographically greater permutation of a string.
 * If no such permutation exists, returns "no answer".
 * BiggerIsGreater
 */

public class BiggerIsGreater {

    /**
     * Finds the next lexicographically greater permutation of the given string.
     * If no such permutation exists, returns "no answer".
     * Example: "ab" -> "ba", "bb" -> "no answer"
     */
    public static String biggerIsGreater(String w) {
        char[] chars = w.toCharArray();
        int i = chars.length - 2;
        while (i >= 0 && chars[i] >= chars[i + 1]) {
            i--;
        }
        if (i < 0) {
            return "no answer";
        }
        int j = chars.length - 1;
        while (chars[j] <= chars[i]) {
            j--;
        }
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        int left = i + 1;
        int right = chars.length - 1;
        while (left < right) {
            temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String input = "ab";
        String result = biggerIsGreater(input);
        System.out.println(result);  // Expected output: "ba"
    }

}
