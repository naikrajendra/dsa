package com.hackerrank.warmup;

/**
 * This class prints the first 'count' numbers in the Fibonacci series.
 * Let's build the sequence step-by-step from the beginning:Start with the first
 * two numbers: 0, 1Add them together (\(0 + 1\)): the next number is 1
 * (Sequence: 0, 1, 1)Add the last two numbers (\(1 + 1\)): the next number is 2
 * (Sequence: 0, 1, 1, 2)Add the last two numbers (\(1 + 2\)): the next number
 * is 3 (Sequence: 0, 1, 1, 2, 3)Add the last two numbers (\(2 + 3\)): the next
 * number is 5 (Sequence: 0, 1, 1, 2, 3, 5)If you keep going, the sequence looks
 * like this:0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144...
 */

public class Fibonacci {

    /*
     * The main method prints the first 'count' numbers in the Fibonacci series.
     */
    public static void main(String[] args) {
        // Number of Fibonacci numbers to print
        int count = 10;
        int first = 0;
        int second = 1;

        System.out.println("Fibonacci Series up to " + count + " terms:");

        for (int i = 1; i <= count; i++) {
            // Print the current number
            System.out.println(first + " ");

            // Calculate the next number by adding the previous two
            int next = first + second;

            // Shift variables forward for the next iteration
            first = second;
            second = next;
        }
    }
}
