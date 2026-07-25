package com.hackerrank.warmup;

/**
 * We define super digit of an integer using the following rules:
 * 
 * Given an integer, we need to find the super digit of the integer.
 * 
 * If has only digit, then its super digit is .
 * Otherwise, the super digit of is equal to the super digit of the sum of the
 * digits of .
 * For example, the super digit of will be calculated as:
 * 
 * super_digit(9875) 9+8+7+5 = 29
 * super_digit(29) 2 + 9 = 11
 * super_digit(11) 1 + 1 = 2
 * super_digit(2) = 2
 * Example
 * 
 * 
 * The number is created by concatenating the string times so the initial .
 * 
 * superDigit(p) = superDigit(9875987598759875)
 * 9+8+7+5+9+8+7+5+9+8+7+5+9+8+7+5 = 116
 * superDigit(p) = superDigit(116)
 * 1+1+6 = 8
 * superDigit(p) = superDigit(8)
 * All of the digits of sum to . The digits of sum to . is only one digit, so it
 * is the super digit.
 * 
 * Function Description
 * 
 * Complete the function superDigit in the editor below. It must return the
 * calculated super digit as an integer.
 * 
 * superDigit has the following parameter(s):
 * 
 * string n: a string representation of an integer
 * int k: the times to concatenate to make
 * Returns
 * 
 * int: the super digit of repeated times
 * Input Format
 * 
 * The first line contains two space separated integers, and .
 * 
 * Constraints
 * 
 * 
 */

public class SuperDigit {

    /*
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. STRING n
     * 2. INTEGER k
     */

    public static int superDigit(String n, int k) {
        long initialSum = 0;

        // Step 1: Add up all the digits in the initial string 'n'
        for (int i = 0; i < n.length(); i++) {
            // Converts character '5' to the actual number 5
            initialSum += n.charAt(i) - '0';
        }

        // Step 2: Multiply by k to get the total sum of the repeated text
        long totalSum = initialSum * k;

        // Step 3: Repeatedly sum the digits until 1 digit is left
        return getSuperDigit(totalSum);
    }

    // This helper method calculates the super digit of any number passed into it
    public static int getSuperDigit(long number) {
        // If the number is already a single digit (0-9), we are done!
        if (number < 10) {
            return (int) number;
        }

        long sumOfDigits = 0;

        // Loop to extract and add up every individual digit
        while (number > 0) {
            sumOfDigits += number % 10; // Grabs the last digit (e.g., 29 % 10 = 9)
            number = number / 10; // Removes the last digit (e.g., 29 / 10 = 2)
        }

        // Keep repeating the process with the new sum
        return getSuperDigit(sumOfDigits);
    }

    public static void main(String[] args) {
        String n = "7875";
        int k = 4;
        int result = superDigit(n, k);
        System.out.println(result); // Expected output: 8
    }

}
