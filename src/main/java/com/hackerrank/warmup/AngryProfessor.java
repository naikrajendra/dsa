package com.hackerrank.warmup;

import java.util.List;

/**
 * AngryProfessor
 *
 * This class contains a method to determine if a class is cancelled based on student 
 * arrival times.
 * A professor has a threshold number of students (k) that must be present on time 
 * for the class to proceed.
 * If the number of students who arrive on time is less than k, the class is cancelled
 * 
 */

public class AngryProfessor {

    /*
     * Complete the 'isClassCancelled' function below.
     *
     * The function is expected to return a String.
     * The function accepts following parameters:
     *  1. int k
     *  2. List<Integer> a
     */

    public static String isClassCancelled(int k, List<Integer> a) {
    // Write your code here
        //loop through a
        //find number of students arrived on time - timelyArrivals
        //if timelyArrivals >= k, class is on, Return NO else return YES
        //k=3
        //{-1,-3,4,2}
        String classCancelled = "";
        int timelyArrivals = 0;
        for(int arrival: a) {
            //-1,-3,4,2
            if ( arrival <= 0) timelyArrivals++; //1,2
        } 
        //2 >= 3
        if (timelyArrivals >= k) classCancelled = "NO";
        else classCancelled = "YES";
        
        return classCancelled;
    }

    public static void main(String[] args) {
        int k = 3;
        List<Integer> a = List.of(-1, -3, 4, 2);
        String result = isClassCancelled(k, a);
        System.out.println(result); // Expected output: YES
    }


}
