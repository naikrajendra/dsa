package com.hackerrank.warmup;

/**
 * Solution for the Viral Advertising problem.
 * 
 */

public class ViralAdvertising {
    /*
     * Complete the 'viralAdvertising' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int viralAdvertising(int n) {
    // Write your code here
        int noOfCumLikes = 0;
        int recipients = 0;
        int liked = 0;
        //loop n
        //Day 1 - recipients - 5
        //liked - Math.floor(recipients/2) = 5/2 = 2
        //noOfCumLikes = noOfCumLikes + liked = 2
        //Day 2 - recipients = liked * 3 = 6
        //liked = Math.floor(recipients/2) = 3 
        //noOfCumLikes = noOfCumLikes + liked = 3+2=5
        for(int i=0; i < n; i++) {
            if( i == 0) recipients = 5; //5
            else recipients = liked * 3;//2*3,3*3
            liked = (int) Math.floor(recipients/2); //2,3,4
            noOfCumLikes += liked;//2,5,9
        }
        return noOfCumLikes;        
           
    }

    public static void main(String[] args) {
        int n = 3;
        int result = viralAdvertising(n);
        System.out.println(result); // Expected output: 9
    }

}
