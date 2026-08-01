package com.hackerrank.warmup;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains a method to track the number of times
 * a player breaks their highest and lowest score records.
 * 
 */

public class BreakingRecords {

        public static List<Integer> breakingRecords(List<Integer> scores) {
    // Write your code here
        int highCounter=0, lowCounter =0;
        int prevHighestScore = 0, prevLowestScore = 0;

        //loop through scores
        for(int i=0; i < scores.size(); i++) { 
            // find each score
            int score = scores.get(i); //3,4.21,36
            if( i ==0) {
                prevHighestScore = score; //3
                prevLowestScore = score; //3
                continue;
            }
            //find highest score
            //if highest score is increased, increment highCounter
            if(score > prevHighestScore) {
                prevHighestScore = score; //4,21,36
                highCounter++;//3
            }
            
            //find lowest score
            //if lowest score is dropped, increment lowCounter
            if(score < prevLowestScore) {
                prevLowestScore = score; 
                lowCounter++;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0,highCounter);
        list.add(1,lowCounter);
        return list;
    }

    public static void main(String[] args) {
        List<Integer> scores = new ArrayList<>();
        scores.add(10);
        scores.add(5);
        scores.add(20);
        scores.add(20);
        scores.add(4);
        scores.add(5);
        scores.add(2);
        scores.add(25);
        scores.add(1);

        List<Integer> result = breakingRecords(scores);
        System.out.println(result); // Output: [2, 4]
    }
}
