package com.hackerrank.warmup;

/***
 * Encrypts a given string by arranging its characters in a grid and reading column-wise.
 * Spaces are removed from the input string before encryption.
 * Example: "have a nice day" -> "hae and via ecy"
 * 
 * Encryption
 */

public class Encryption {

    public static String encryption(String s) {
        // 1. Remove spaces from the string
        String s1 = s.replaceAll("\\s+", "");
        int s1Length = s1.length();
        
        if (s1Length == 0) {
            return "";
        }

        // 2. Calculate rows and columns based on the square root of the length
        double sqrt = Math.sqrt(s1Length);
        int rows = (int) Math.floor(sqrt);
        int cols = (int) Math.ceil(sqrt);
        
        // Ensure the grid area is large enough to fit all characters (rows * cols >= L)
        if (rows * cols < s1Length) {
            rows++;
        }

        // 3. Build the encrypted string column by column
        StringBuilder builder = new StringBuilder();
        
        for (int c = 0; c < cols; c++) {
            if (c > 0) {
                builder.append(" "); // Separate words by a space, not a newline
            }
            
            // Grab characters in the current column across all rows
            for (int r = 0; r < rows; r++) {
                int index = r * cols + c;
                if (index < s1Length) {
                    builder.append(s1.charAt(index));
                }
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        String input = "have a nice day";
        String encrypted = encryption(input);
        System.out.println(encrypted);  
    }
}
