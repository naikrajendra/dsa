package com.hackerrank.warmup;

import java.util.Collections;
import java.util.List;

/**
 * PickingNumbers
 *
 * This class contains a method to determine the maximum length of a subarray
 * where the absolute difference between any two elements is at most 1.
 */
public class PickingNumbers {

    public static int pickingNumbers(List<Integer> a) {
        // Write your code here
        //firstpointer pointing at 0;
        //secondpointer pointing at position 0;
        //diff first and second is <1, increment second pointer i
        //keep moving the secondpointer till diff becomes > 1
        //when diff becomes > 1, move firstpointer to secondpointer position i
        //Keep counting the arrayElements
        //[1,1,2,2,4,4,5,5,5]
        //4 6 5 3 3 1
        // 1. Must sort the list first
        Collections.sort(a);
        
        int firstPointer = 0;
        int maxCount = 0;
        
        // 2. Sliding window
        for (int i = 0; i < a.size(); i++) {
            // Compare current element to the start of the valid window
            if (Math.abs(a.get(i) - a.get(firstPointer)) > 1) {
                // Shrink window from the left until the condition is met again
                firstPointer = i;
            }
            // Window size is always the distance between the two pointers
            maxCount = Math.max(maxCount, i - firstPointer + 1);
        }
        
        return maxCount;    
    }

    public static void main(String[] args) {
        List<Integer> a = List.of(4, 6, 5, 3, 3, 1);
        System.out.println(pickingNumbers(a));
    }

}
