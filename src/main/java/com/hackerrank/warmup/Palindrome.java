package com.hackerrank.warmup;

/**
 * Check Palindrome by Filtering Non-Letters
 * Given a string containing letters, digits, and symbols, determine if it reads
 * the same forwards and backwards when considering only alphabetic characters
 * (case-insensitive).
 * 
 * Example
 * 
 * Input
 * 
 * code = A1b2B!a
 * Output
 * 
 * 1
 * Explanation
 * 
 * - Step 1: Extract only letters → ['A','b','B','a']
 * - Step 2: Convert to lowercase → ['a','b','b','a']
 * - Step 3: Compare sequence forward and backward: 'abba' == 'abba' → true
 * 
 */

public class Palindrome {

    public static boolean isAlphabeticPalindrome(String code) {
        // Write your code here
        if (code == null)
            return false;
        // remove non aphabe<tic characters
        code = code.replaceAll("[^a-zA-Z]", "").toLowerCase();
        // two pointers
        int left = 0;
        int right = code.length() - 1;
        while (left < right) {
            if (code.charAt(left) != code.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String code = "A1b2B!a";
        boolean result = isAlphabeticPalindrome(code);
        System.out.println(result ? 1 : 0); // Output: 1
    }

}
