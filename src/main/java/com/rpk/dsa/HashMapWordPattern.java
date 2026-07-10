package com.rpk.dsa;

import java.util.HashMap;
import java.util.Map;

public class HashMapWordPattern {

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false; // Length mismatch
        }

        Map<Character, String> charToWordMap = new HashMap<>();
        Map<String, Character> wordToCharMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (charToWordMap.containsKey(c)) {
                if (!charToWordMap.get(c).equals(word)) {
                    return false; // Mismatch in mapping
                }
            } else {
                charToWordMap.put(c, word);
            }

            if (wordToCharMap.containsKey(word)) {
                if (!wordToCharMap.get(word).equals(c)) {
                    return false; // Mismatch in mapping
                }
            } else {
                wordToCharMap.put(word, c);
            }
        }

        return true; // Pattern matches
    }   

    public static void main(String[] args) {
        HashMapWordPattern hwp = new HashMapWordPattern();
        String pattern = "abba";
        String s = "dog cat cat dog";

        boolean result = hwp.wordPattern(pattern, s);
        if (result) {
            System.out.println("The string follows the pattern.");
        } else {
            System.out.println("The string does not follow the pattern.");
        }
    }


}
