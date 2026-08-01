package com.hackerrank.warmup;

import java.util.List;

/**
 * A class to find the number of pairs in an array whose sum is divisible by a
 * given integer k.
 * 
 * DivisibleSumPairs
 */

public class DivisibleSumPairs {

    /*
     * Complete the 'divisibleSumPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER_ARRAY ar
     */

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
    // Write your code here
        //loop through ar
        //find ith element starting with 0;
        //loop through ar
        //find i+1th element
        // add i + i+1 element
        // divide by k
        // if divisible, increment pairCount
        int pairCount = 0;
        //[1, 3, 2, 6, 1, 2] 6 3
        for(int i=0; i < ar.size(); i++) {
            for(int j=i+1; j < ar.size(); j++) { 
                int sum = ar.get(i) + ar.get(j); 
                //1+3=4, 1+2=3, 1+6=7, 1+1=2,1+2=3
                //3+2=5, 3+6=9, 3+1, 3+2
                //2+6, 2+1=3, 2+2
                //6+1, 6+2
                //1+2
                if(sum%k == 0) {
                    pairCount++; //5
                }
            }
        }
        return pairCount;
    }

    public static void main(String[] args) {
        List<Integer> ar = List.of(1, 3, 2, 6, 1, 2);
        int n = ar.size();
        int k = 3;
        int result = divisibleSumPairs(n, k, ar);
        System.out.println(result); // Output: 5
    }


}
