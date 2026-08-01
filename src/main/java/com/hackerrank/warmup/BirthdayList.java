package com.hackerrank.warmup;

import java.util.ArrayList;
import java.util.List;

/**
 * BirthdayList class provides a method to count the number of ways a list of 
 * integers can be divided into contiguous segments of a given length that 
 * sum to a specified value.
 */

public class BirthdayList {

    public static int birthday(List<Integer> s, int d, int m) {
        int count = 0;
        for (int i = 0; i <= s.size() - m; i++) {
            int sum = 0;
            for (int j = i; j < i + m; j++) {
                sum += s.get(j);
            }
            if (sum == d) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> s = new ArrayList<>();
        s.add(1);
        s.add(2);
        s.add(1);
        s.add(3);
        s.add(2);
        int d = 3;
        int m = 2;
        System.out.println(birthday(s, d, m));
    }
}
