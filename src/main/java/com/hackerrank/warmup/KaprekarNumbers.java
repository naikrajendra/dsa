package com.hackerrank.warmup;

public class KaprekarNumbers {

    public static void kaprekarNumbers(int p, int q) {
        StringBuilder result = new StringBuilder();

        for (int i = p; i <= q; i++) {
            // Use 'long' to prevent integer overflow when squaring large numbers
            long squared = (long) i * i; 
            String s = Long.toString(squared);
            int d = Integer.toString(i).length(); // Number of digits in the original number

            // Split the squared string: right part gets 'd' digits, left gets the rest
            String leftStr = s.substring(0, s.length() - d);
            String rightStr = s.substring(s.length() - d);

            // Convert the string parts back to numbers (default to 0 if left part is empty)
            long left = leftStr.isEmpty() ? 0 : Long.parseLong(leftStr);
            long right = rightStr.isEmpty() ? 0 : Long.parseLong(rightStr);

            // Check if the sum of the two halves equals the original number
            if (left + right == i) {
                if (result.length() > 0) {
                    result.append(" ");
                }
                result.append(i);
            }
        }

        // Output the results or the fallback message
        if (result.length() == 0) {
            System.out.println("INVALID RANGE");
        } else {
            System.out.println(result.toString());
        }
    }
    
    public static void main(String[] args) {
        kaprekarNumbers(1, 100);
    }

}
