package com.rpk.dsa;

/**
 * This class provides a method to check if two strings are anagrams of each other.
 * An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * The method uses an integer array to count the occurrences of each character in the strings.      
 * 
 */

public class HashMapAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false; // Length mismatch
        }

        int[] charCount = new int[26]; // Assuming only lowercase letters

        for (char c : s.toCharArray()) {
            charCount[c - 'a']++; // Increment count for character in s
        }

        for (char c : t.toCharArray()) {
            charCount[c - 'a']--; // Decrement count for character in t
            if (charCount[c - 'a'] < 0) {
                return false; // More occurrences in t than in s
            }
        }

        return true; // All counts are zero, so they are anagrams
    }

    public static void main(String[] args) {
        HashMapAnagram ha = new HashMapAnagram();
        String s = "anagram";
        String t = "nagaram";

        boolean result = ha.isAnagram(s, t);
        if (result) {
            System.out.println("The strings are anagrams.");
        } else {
            System.out.println("The strings are not anagrams.");
        }
    }

}
