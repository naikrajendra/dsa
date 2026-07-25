package com.hackerrank.warmup;

/**
 * Staircase detail
 * This is a staircase of size :
 * #
 * ##
 * ###
 * ####
 * Its base and height are both equal to . It is drawn using # symbols and
 * spaces. The last line is not preceded by any spaces.
 * Write a program that prints a staircase of size .
 * Function Description
 * Complete the function with the following parameter(s):
 *
 * : an integer
 * Print
 *
 * Print a staircase as described above. No value should be returned.
 * Note: The last line is not preceded by spaces. All lines are right-aligned.
 * Input Format
 *
 * A single integer, , denoting the size of the staircase.
 * Staircase
 * 
 */

public class Staircase {

    /*
     * Complete the 'staircase' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void staircase(int n) {
        // Write your code here
        for (int i = 1; i <= n; i++) {
            // Print (n - i) spaces followed by (i) hashes
            System.out.println(" ".repeat(n - i) + "#".repeat(i));
        }
    }

    public static void main(String[] args) {
        staircase(6);
    }

}
