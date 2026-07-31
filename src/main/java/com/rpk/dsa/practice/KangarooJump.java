package com.rpk.dsa.practice;

/**
 * 
 * Given the starting positions and velocities of two kangaroos on a number line, 
 * determine if they will land on the same location after making the same number of jumps.
 * 
 * KangarooJump
 */

public class KangarooJump {

        public static String kangaroo(int x1, int v1, int x2, int v2) {
            // Write your code here
            // 43 2 43 2
            // 0 3 4 2
            int kangarooOne = x1 + v1; //45
            int kangarooTwo = x2 + v2; // 72
            if (kangarooTwo == kangarooOne) return "YES";
            // 43 < 70, 2
            if( (x1 <= x2 && v1 <= v2) || (x2 <= x1 && v2 <= v1) ) return "NO";
            
            while(kangarooTwo != kangarooOne) { // 27,50
                kangarooOne += v1; // 33, 39, 45, 51, 57, 63, 69, 75
                kangarooTwo += v2; // 53, 56, 59, 62, 65, 68, 71, 74
                if(x1<x2 && v1 > v2) {
                    if(kangarooOne > kangarooTwo) return "NO";
                } else if (x2>x1 && v2 < v1) {
                    if(kangarooTwo > kangarooOne) return "NO";
                    
                }
                if (kangarooTwo == kangarooOne) return "YES";
            }
            return "NO";
    }

    public static void main(String[] args) {
        int x1 = 43;
        int v1 = 2;
        int x2 = 70;
        int v2 = 2;
        System.out.println(kangaroo(x1, v1, x2, v2));
    }

}
