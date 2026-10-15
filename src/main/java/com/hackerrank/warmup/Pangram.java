package com.hackerrank.warmup;

import java.util.HashSet;

/* 
 * This class contains a method to check if a given string is a pangram.
 * A pangram is a sentence that contains every letter of the alphabet at least once.
 * Example usage:
 * Pangram.pangrams("The quick brown fox jumps over the lazy dog"); // returns "pangram"
 * Pangram.pangrams("Hello World"); // returns "not pangram"
 * Pangram.pangrams("Pack my box with five dozen liquor jugs"); // returns "pangram"
 * Pangram.pangrams("Sphinx of black quartz, judge my vow"); // returns "pangram"
 *  
*/

public class Pangram {

    public static String pangrams(String s) {
    // Write your code here
        //create hashmap of chars
        //read each character from s
        //after the loop ends, check number of characters in hashmap
        //if chars == 26 return pangram else not pangram
        String result = "";
        HashSet<Character> set = new HashSet();
        s = s.toLowerCase();
        for(int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isLetter(c)) set.add(c);    
        }
        if(set.size()==26) {
           result = "pangram"; 
        } else {
            result = "not pangram";
        }
        return result;

    }

    public static void main(String[] args) {
        String testString = "The quick brown fox jumps over the lazy dog";
        System.out.println(pangrams(testString));
        String testString2 = "Hello World";
        System.out.println(pangrams(testString2));
        String testString3 = "Pack my box with five dozen liquor jugs";
        System.out.println(pangrams(testString3));
        String testString4 = "Sphinx of black quartz, judge my vow";
        System.out.println(pangrams(testString4));
    }

}
