package com.hackerrank.warmup;

import java.util.List;

/**
 * Finds the minimum distance between equal elements in a list of integers.
 * Returns -1 if no such elements exist.
 * MinimumDistances
 */
public class MinimumDistances {

    public static int minimumDistances(List<Integer> a) {
    // Write your code here
        //
        int minimumDistances = -1;
        int len = 0;
        if(a != null && a.size() > 0) {
            len = a.size(); //5
        }
        //3,2,1,2,3
        //7 1 3 4 1 7
        for(int i=0; i < len; i++) {
            for(int j=i+1; j < len; j++) {
                if(a.get(i).equals(a.get(j))) { //7==2, 3==1, 3==2,3==3
                    if(minimumDistances < 0 ) minimumDistances = (j-i);
                    else minimumDistances = Math.min(minimumDistances, (j-i)); //4
                }
            }           
        }
        
        return minimumDistances;

    }

    public static void main(String[] args) {
        List<Integer> a = List.of(7, 1, 3, 4, 1, 7);
        int result = minimumDistances(a);
        System.out.println(result);
    }
}
