package com.hackerrank.warmup;

/**
 * Solution to the Mars Exploration problem.
 * Counts the number of altered characters in a received SOS message.
 * Example usage:
 * String s = "SOSSPSSQSSOR";
 * int result = MarsExploration.marsExploration(s);
 * System.out.println(result); // Output: 3
 * 
 * The input string is assumed to be a multiple of 3 in length.
 * Assumes the message only contains uppercase English letters.
 * 
 * @param s the received SOS message
 * @return the number of altered characters in the message
 *         Example:
 *         marsExploration("SOSSPSSQSSOR") returns 3
 *         MarsExploration
 */

public class MarsExploration {

    public static int marsExploration(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i += 3) {
            if (s.charAt(i) != 'S')
                count++;
            if (s.charAt(i + 1) != 'O')
                count++;
            if (s.charAt(i + 2) != 'S')
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "SOSSPSSQSSOR";
        int result = marsExploration(s);
        System.out.println(result);

    }
}
