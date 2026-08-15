package com.hackerrank.warmup;

/**
 * Solution for the "Append and Delete" problem.
 * 
 * AppendAndDelete
 */


public class AppendAndDelete {

    public static String appendAndDelete(String s, String t, int k) {
        // Write your code here
        int commonLength = 0;
        int minLength = Math.min(s.length(), t.length());
        
        // Find the length of the common prefix
        for (int i = 0; i < minLength; i++) {
            if (s.charAt(i) == t.charAt(i)) {
                commonLength++;
            } else {
                break;
            }
        }
        
        int totalOperations = (s.length() - commonLength) + (t.length() - commonLength);
        
        if (totalOperations > k) {
            return "No";
        } else if ((k - totalOperations) % 2 == 0 || k >= s.length() + t.length()) {
            return "Yes";
        } else {
            return "No";
        }
    }

    public static void main(String[] args) {
        String s = "hackerhappy"; // Example input
        String t = "hackerrank"; // Example input
        int k = 9; // Example input
        String result = appendAndDelete(s, t, k);
        System.out.println(result); // Expected output: Yes
    }
}
