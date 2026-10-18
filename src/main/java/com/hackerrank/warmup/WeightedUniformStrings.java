package com.hackerrank.warmup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Determines if the weights of uniform substrings of a given string match the
 * specified queries.
 * A uniform substring consists of consecutive identical characters, and its
 * weight is the sum of the character's position in the alphabet multiplied by
 * its length.
 * For each query, returns "Yes" if there exists a uniform substring with that
 * weight, otherwise "No".
 * Example: s = "abccddde", queries = [1, 3, 12, 5, 9, 10] -> ["Yes", "Yes",
 * "No", "Yes", "No", "No"]
 * 
 * WeightedUniformStrings
 */

public class WeightedUniformStrings {

    public static List<String> weightedUniformStrings(String s, List<Integer> queries) {
        // Write your code here
        // create a HashMap of char and int weight
        // create HashSet of associate values
        // loop through s
        // find each character and find its associated weight and add it to HashSet
        // if char is same as previous char, then muliply and add its associated weight
        // after loop is complete
        // Loop through the queries and check if has possible string weights
        ArrayList<String> result = new ArrayList<>();
        if (s == null & s.length() <= 0)
            return result;
        HashSet<Integer> set = new HashSet<>();
        char prevChar = ' ';
        int currentWeight = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int baseWeight = c - 'a' + 1; // HackerRank spec uses strictly lowercase alphabets

            if (c == prevChar) {
                // Consecutive match: Accumulate the weight sequentially
                currentWeight += baseWeight;
            } else {
                // New character sequence: Reset weight to base value
                currentWeight = baseWeight;
                prevChar = c;
            }

            set.add(currentWeight);
        }
        for (int j = 0; j < queries.size(); j++) {
            int query = queries.get(j);
            if (set.contains(query)) {
                result.add("Yes");
            } else {
                result.add("No");
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "abccddde";
        List<Integer> queries = List.of(1, 3, 12, 5, 9, 10);
        List<String> result = weightedUniformStrings(s, queries);
        for (String res : result) {
            System.out.println(res);
        }
    }
}
