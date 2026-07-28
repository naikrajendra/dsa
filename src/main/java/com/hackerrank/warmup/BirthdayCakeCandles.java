package com.hackerrank.warmup;

import java.util.List;

/**
 * You are in charge of the cake for a child's birthday. It will have one candle for each year of their total age. They will only be able to blow out the tallest of the candles. Your task is to count how many candles are the tallest.
 * Example
 * The tallest candles are 4 units high. There are 2 candles with this height, so the function should return 2.
 * Function Description
 * Complete the function  with the following parameter(s):
 * : the candle heights
 * Returns
 * the number of candles that are tallest
 * 
 * Example
 * candles = [4,4,1,3]
 * output: 2
 * 
 * 
 * 
 */

public class BirthdayCakeCandles {

    public static int birthdayCakeCandles(List<Integer> candles) {
    // Write your code here
        if(candles == null || candles.size() < 1 ) return 0;
        int noOfTallCandles = 0;
        int maxCandleHeight = Integer.MIN_VALUE; // -2170000
        // find maxCandleHeight
        // [4,4,1,3]        
        for(int candleHeight : candles) {
            maxCandleHeight = Math.max(maxCandleHeight, candleHeight); //4
        }
        // maxCandleHeight 4
        //count how many times maxCandleHeight is occuring in array
        // [4,4,1,3]
        for(int candleHeight : candles) {
            // 4, 4, 1, 3
            if(candleHeight == maxCandleHeight) {
                noOfTallCandles++; // 1, 2
            };
        }
       return noOfTallCandles; 
    }


}
