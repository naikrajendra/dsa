package com.hackerrank.warmup;

/**
 * CountingValleys
 *
 * This class contains a method to count the number of valleys
 * traversed during a hike. A valley is defined as a sequence of
 * consecutive steps below sea level, starting with a step down
 * from sea level and ending with a step up to sea level.
 */

public class CountingValleys {

    public static int countingValleys(int steps, String path) {
    // Write your code here
        //create return variable
        int valleyCount = 0;
        int seaLevelHeight = 0;
        //UDDDUDUU
        for(int i=0; i < steps; i++) {
            char c = path.charAt(i); //U,D,D,D,U,D
            if(c=='U') {
                seaLevelHeight++; //1 -2+1=-1
                if (seaLevelHeight == 0) {
                    valleyCount++;
                }
            } else if (c=='D') {
              seaLevelHeight--; // 1-1=0, 0-1=-1 -1-1=-2
            } 
        }
         
        
        return valleyCount;
    }

    public static void main(String[] args) {
        int steps = 8;
        String path = "UDDDUDUU";
        System.out.println(countingValleys(steps, path));
    }

}
