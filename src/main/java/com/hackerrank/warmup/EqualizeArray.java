package com.hackerrank.warmup;

import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

public class EqualizeArray {

    public static int equalizeArray(List<Integer> arr) {
    // Write your code here
        int len = arr.size();
        int deletionCount = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i < len; i++) {
            int a = arr.get(i);
            if(map.containsKey(a)) {
                int count = map.get(a);
                map.put(a, count+1);
            } else {
                map.put(a, 1);
            }
        }
        // (3,3}, {2,1}, {1,1}
        // Step 2: Find the frequency of the most common element
        int maxTimes = 0;
        for (int count : map.values()) {
            maxTimes = Math.max(maxTimes, count);
        }
        
        // Step 3: Deletions = total elements minus the elements we keep
        deletionCount = len - maxTimes;
                    
        return deletionCount;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(3, 3, 2, 1, 3);
        int result = equalizeArray(arr);
        System.out.println(result); // Expected output: 2
    }

}
