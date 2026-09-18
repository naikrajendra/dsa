package com.hackerrank.warmup;

/**
 * Counts the number of words in a camelCase string.
 * A word is defined as a sequence of characters starting with an uppercase letter, except for the first word which starts with a lowercase letter.
 * For example, "saveChangesInTheEditor" has 5 words: "save", "Changes", "In", "The", "Editor".
 * Example usage:
 * CamelCase.camelcase("saveChangesInTheEditor"); // returns 5
 * Output: 5    
 * Another example:
 * CamelCase.camelcase("oneTwoThree"); // returns 3
 * Output: 3
 * Notes:
 * - The first word is always considered to start with a lowercase letter.
 * - Each subsequent word starts with an uppercase letter.
 * - The method counts the number of words based on these rules.
 * 
 * @author Rajendra Naik
 * @version 1.0
 *
 * CamelCase
 */
public class CamelCase {

    public static int camelcase(String s) {
        // Write your code here
        // wordCounter = 0
        // loop through each character in String s
        // check if character is upperCase
        // if yes, increment wordCounter
        //return wordCounter
        int wordCounter = 1;
        for(int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c) == true) wordCounter++;
        }
        return wordCounter;
    }

    public static void main(String[] args) {
        String testString = "saveChangesInTheEditor";
        int wordCount = camelcase(testString);
        System.out.println("Number of words: " + wordCount);
    }

}
