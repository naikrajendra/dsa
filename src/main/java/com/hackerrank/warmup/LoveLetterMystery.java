package com.hackerrank.warmup;

/**
 * Given a string, determine the minimum number of operations required to
 * convert it into a palindrome.
 * In one operation, you can reduce the value of a letter by 1 (e.g., 'd' to
 * 'c').
 * The function returns the total number of operations needed.
 * 
 * LoveLetterMystery
 */

public class LoveLetterMystery {

    public static int theLoveLetterMystery(String s) {
        // create firstpointer and lastpointer
        // check the lastpointer char with firstpointer char
        // if same go to next char, firstpointer++, lastpointer--
        // if not same then check the difference between them and add to flipcounter
        int numberOfOps = 0;
        // boundry condition
        if (s == null && s.length() <= 0)
            return numberOfOps;

        int firstpointer = 0;
        int lastpointer = s.length() - 1;

        while (firstpointer < lastpointer) {
            char c1 = s.charAt(firstpointer);
            char c2 = s.charAt(lastpointer);
            numberOfOps += Math.abs(c1 - c2);
            firstpointer++;
            lastpointer--;
        }
        return numberOfOps;
    }

    public static void main(String[] args) {
        System.out.println(theLoveLetterMystery("abc"));
        System.out.println(theLoveLetterMystery("abcd"));
    }

}
