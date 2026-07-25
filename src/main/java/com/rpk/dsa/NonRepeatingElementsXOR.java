package com.rpk.dsa;

/**
 * NonRepeatingElementsXOR
 *
 * This class provides a solution to find two non-repeating elements in an array
 * where every other element repeats exactly twice. It uses the XOR bitwise operation
 * to achieve this in linear time and constant space.
 * 
 */


public class NonRepeatingElementsXOR {

    public static void findNonRepeatingElements(int[] arr) {
        int xorResult = 0;

        // Step 1: XOR all elements in the array
        for (int num : arr) {
            xorResult ^= num;
        }

        // Step 2: Find a set bit (rightmost set bit)
        int setBit = xorResult & -xorResult;

        int num1 = 0, num2 = 0;

        // Step 3: Divide elements into two groups and XOR separately
        for (int num : arr) {
            if ((num & setBit) != 0) {
                num1 ^= num; // Group with the set bit
            } else {
                num2 ^= num; // Group without the set bit
            }
        }

        System.out.println("The two non-repeating elements are: " + num1 + " and " + num2);
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 4, 5};
        findNonRepeatingElements(arr);
    }

}
