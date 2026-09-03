package com.hackerrank.warmup;

import java.util.List;

/**
 * This class contains a method to count the number of beautiful triplets in a given list of integers.  
 * A beautiful triplet is defined as a triplet of indices (i, j, k) such that:
 * - i < j < k
 * - arr[j] - arr[i] = d
 * - arr[k] - arr[j] = d
 *  
 * BeautifulTriplets
 */

public class BeautifulTriplets {

    public static int beautifulTriplets(int d, List<Integer> arr) {
        int beautifulTripletsCount = 0;
        int n = arr.size();
        for(int i=0; i < arr.size()-2; i++) {
            int secondPointer = i+1; //4
            int thirdPointer = i+2; //5
            
            while(secondPointer < n && (arr.get(secondPointer) - arr.get(i)) != d) {
                secondPointer++; //2
                if(thirdPointer < arr.size())thirdPointer++; //3
            }
            if(secondPointer < n && (arr.get(secondPointer) - arr.get(i) == d)) {
                thirdPointer = secondPointer + 1;
                while (thirdPointer < n && (arr.get(thirdPointer) - arr.get(secondPointer)) != d) {
                    thirdPointer++;
                }
                if(thirdPointer < n && (arr.get(thirdPointer) - arr.get(secondPointer)) == d) {
                   beautifulTripletsCount++; 
                }
                
            }
        }
        
        return beautifulTripletsCount;
        
    }

    public static void main(String[] args) {
        List<Integer> arr = List.of(1, 2, 4, 5, 7, 8, 10);
        int d = 3;
        int result = beautifulTriplets(d, arr);
        System.out.println("Number of beautiful triplets: " + result);
    }
}
