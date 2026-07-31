package com.hackerrank.warmup;

import java.util.List;

/**
 * 
 * Given the locations of a house and the positions of apple and orange trees, count how many apples and oranges fall on the house. 
 * 
 * CountApplesAndOranges
 */

public class CountApplesAndOranges {

        /*
     * Complete the 'countApplesAndOranges' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER s
     *  2. INTEGER t
     *  3. INTEGER a
     *  4. INTEGER b
     *  5. INTEGER_ARRAY apples
     *  6. INTEGER_ARRAY oranges
     */
    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        int appleCount =0;
        int orangeCount = 0;
        
        if(apples == null && apples.size() <= 0) appleCount = 0;
        if(oranges == null && oranges.size() <= 0 ) orangeCount = 0;
        
        for(int appleDistance : apples) {
            int newAppleDistance = a + appleDistance; // 4+2, 4+3, 4-4
            if(newAppleDistance >= s && newAppleDistance <= t) {
                appleCount++; // 1
            }
        }
        
        for(int orangeDistance : oranges) {
            int newOrangeDistance = b + orangeDistance; //12+3, 12-2, 12-4
            if(newOrangeDistance >= s && newOrangeDistance <= t) {
                orangeCount++; // 1,2
            }
        }
        System.out.println(appleCount); //1
        System.out.println(orangeCount); //2

    }

    public static void main(String[] args) {
        int s = 7;
        int t = 11;
        int a = 5;
        int b = 15;
        List<Integer> apples = List.of(-2, 2, 1);
        List<Integer> oranges = List.of(5, -6);
        countApplesAndOranges(s, t, a, b, apples, oranges);
    }


}
