package com.hackerrank.warmup;

import java.util.List;

/**
 * HurdleRace
 *
 * This class contains a method to determine the minimum number of doses
 * a character needs to jump over all hurdles in a race.
 */

public class HurdleRace {
    /*
     * Complete the 'hurdleRace' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY height
     */

    public static int hurdleRace(int k, List<Integer> height) {
    // Write your code here
        //loop through height
        // find max height
        // dosage = Math.abs(max height - k); non negative mumber 
        int dose = 0;
        int maxHeight = 0;
        for(int h: height) {
            maxHeight = Math.max(maxHeight, h);
        }
        dose = Math.max(0,maxHeight - k);
        return dose;
    }

    public static void main(String[] args) {
        List<Integer> height = List.of(1, 2, 3, 3, 2);
        int k = 1;
        int result = hurdleRace(k, height);
        System.out.println(result); // Expected output: 2
    }

}
