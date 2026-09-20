package com.hackerrank.warmup;

/**
 * Reduces a string by removing pairs of adjacent matching characters until no more such pairs exist.
 * If the final string is empty, returns "Empty String".    
 * Example:
 * Input: "aaabccddd"
 * Output: "abd"
 * Input: "aa"
 * Output: "Empty String"
 * 
 * Usage:
 * String result = SuperReducedString.superReducedString("aaabccddd");
 * System.out.println(result); // Output: "abd"
 * Example with empty result:
 * String result2 = SuperReducedString.superReducedString("aa");
 * System.out.println(result2); // Output: "Empty String"
 *  
 * This class provides a method to reduce strings as described above.
 * Example usage is provided in the main method.
 * @author Rajendra Naik
 * @version 1.0
 * @since 2024-06-12
 * 
 * SuperReducedString
 */
public class SuperReducedString {

    public static String superReducedString(String s) {
        StringBuilder sb = new StringBuilder(s);
        
        for (int i = 0; i < sb.length() - 1; i++) {
            // If adjacent characters match
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                sb.delete(i, i + 2); // Delete both characters
                i = -1;              // Reset index to restart from the beginning
            }
        }
        
        return sb.length() == 0 ? "Empty String" : sb.toString();
    }

    public static void main(String[] args) {
        String input = "aaabccddd";
        String result = superReducedString(input);
        System.out.println(result);

    }
}
