package com.hackerrank.warmup;

/**
 * UtopianTree
 *
 * This class contains a method to calculate the height of the Utopian Tree
 * after a given number of growth cycles.
 * The Utopian Tree goes through 2 cycles of growth every year. Each spring, 
 * it doubles in height. Each summer, its height increases by 1 meter.
 * A Utopian Tree sapling with a height of 1 meter is planted at the onset of spring. 
 * How tall will the tree be after n growth cycles?
 */

public class UtopianTree {

    /*
     * Complete the 'utopianTree' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int utopianTree(int n) {
    // Write your code here
        //loop from 0..n
        //if it n=oddNumber height = height * 2
        //else if n=evenNumber add +1 to height
        //return height
        int height = 0;
        //period: 0,1,2,3 
        //height: 1,2,3,
        for(int i=0; i<=n; i++) {
            //System.out.println("i=" + i);
            if(i%2!=0) {
                //System.out.println("i%2!=0");
                height = height * 2;
                //System.out.println("height=" + height);
            } else {
                //System.out.println("i%2==0");
                height = height + 1;
                //System.out.println("height=" + height);
            }
        }
        return height;
        
    }

    public static void main(String[] args) {
        int n = 5;
        int result = utopianTree(n);
        System.out.println(result); // Expected output: 14
    }
}
