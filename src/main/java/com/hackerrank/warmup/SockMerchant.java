package com.hackerrank.warmup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SockMerchant class provides a method to count the number of pairs of socks 
 * with matching colors in a given list.
 * 
 * SockMerchant
 */

public class SockMerchant {
    public static int sockMerchant(int n, List<Integer> ar) {
    // Write your code here
        int numSockPairs = 0;
        //map <color,count>
        HashMap<Integer, Integer>  map = new HashMap<>();
        //for loop to create color and map
        //[1,2,1,2,1,3,2]
        for(int i: ar) {
            if(!map.containsKey(i)) { //1,2,1,2,3,2
                map.put(i, 1); // {1,1} {2,1} {3,1}
            } else {
                map.put(i, map.get(i) + 1); // {1,2} {2,3} 
            }
        }
        // for loop on the map, 
        // {1,2}, {2,3}, {3,1}
        for(Map.Entry<Integer,Integer> entry: map.entrySet() ) {
            //{1,2}, {2,3}, {3,1}
            int pair = entry.getValue() / 2; // 2/2=1 3/2=1 1/2=0
            numSockPairs += pair; //1,2  
        }
        // Divide count / 2, add it to numSockPairs
        // return numSockPairs
        return numSockPairs;
    }

    public static void main(String[] args) {
        List<Integer> ar = List.of(1, 2, 1, 2, 1, 3, 2);
        int n = ar.size();
        System.out.println(sockMerchant(n, ar));
    }

}
