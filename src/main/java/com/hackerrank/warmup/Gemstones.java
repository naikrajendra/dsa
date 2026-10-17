package com.hackerrank.warmup;

import java.util.HashMap;
import java.util.List;

public class Gemstones {

    public static int gemstones(List<String> arr) {
        // Write your code here
        // Loop through arrayList of Strings
        // get string[i]
        // loop through each char in string[i]
        // add char in HashMap
        // loop next string
        // find each char in string
        // if char exists in HashMap, increment it else add
        // after that loop HashMap
        // if char count == List of String count
        // mark it gemstone and increment gemstone counter
        int gemstoneCounter = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        if (arr == null && arr.size() <= 0)
            return gemstoneCounter;
        for (int i = 0; i < arr.size(); i++) {
            String s = arr.get(i);
            if (s == null || s.length() <= 0)
                continue;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (i == 0) {
                    if (!map.containsKey(c)) {
                        map.put(c, 1);
                    }
                } else {
                    if (map.containsKey(c)) {
                        int count = (int) map.get(c);
                        if (count == i)
                            map.put(c, (int) map.get(c) + 1);
                    }

                }
            }
        }
        for (Integer value : map.values()) {
            if (value == arr.size())
                gemstoneCounter++;
        }
        return gemstoneCounter;
    }

    public static void main(String[] args) {
        List<String> arr = List.of("abcdde", "baccd", "eeabg");
        System.out.println(gemstones(arr));
    }
}
