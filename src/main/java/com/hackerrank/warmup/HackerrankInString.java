package com.hackerrank.warmup;

/**
 * Determines if the string "hackerrank" is a subsequence of the input string.
 * Returns "YES" if it is, otherwise returns "NO".
 * Example: hackerrankInString("hereiamstackerrank") returns "YES"
 * hackerrankInString("hackerworld") returns "NO"
 * 
 * @param s the input string to check
 * @return "YES" if "hackerrank" is a subsequence of s, otherwise "NO"
 * 
 *         HackerrankInString
 */

public class HackerrankInString {

    public static String hackerrankInString(String s) {
        // Write your code here
        String result = "NO";
        String input = "hackerrank";
        int startCounter = 0;
        for (int i = 0; i < input.length(); i++) {
            boolean found = false;
            char c1 = input.charAt(i);
            for (int j = startCounter; j < s.length(); j++) {
                char c2 = s.charAt(j);
                if (c2 == c1) {
                    startCounter = j + 1;
                    found = true;
                    break;
                }
            }
            if (found) {
                continue;
            } else {
                return result;
            }

        }
        result = "YES";
        return result;
    }

    public static void main(String[] args) {
        String testString = "hereiamstackerrank";
        System.out.println(hackerrankInString(testString));

    }
}
