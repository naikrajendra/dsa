package com.hackerrank.warmup;

/**
 * BeautifulDays
 *
 * This class contains a method to calculate the number of beautiful days
 * within a given range. A beautiful day is defined as a day where the
 * absolute difference between the day and its reverse is divisible by k.
 * 
 */

public class BeautifulDays {

    /*
     * Complete the 'beautifulDays' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER i
     *  2. INTEGER j
     *  3. INTEGER k
     */

    public static int beautifulDays(int i, int j, int k) {
    // Write your code here
        // i  = start day
        // j = end day
        // k = divisor
        //loop i to j
        //for each dayNumber
        //(dayNumber-reverseDayNumber)/k % 1 == 0, add to beautifulDaysCounter
        //20,23,6
        //a=20
        
        int beautifulDaysCounter = 0;
        for (int a=i; a <= j; a++) {
            int dayNumber = a;
            int reverseDayNumber = 0;
            //20
            while(dayNumber !=0) {
                int digit = dayNumber % 10; //2
                reverseDayNumber = reverseDayNumber * 10 + digit; //2
                dayNumber = dayNumber/10; //2
            }
            if ((a - reverseDayNumber) % k == 0)  beautifulDaysCounter++;      
        }
        
        return beautifulDaysCounter; 
    }

    public static void main(String[] args) {
        int i = 20;
        int j = 23;
        int k = 6;
        int result = beautifulDays(i, j, k);
        System.out.println(result); // Expected output: 2
    }

}
