package com.hackerrank.warmup;

/**
 * 
 * Implementation of the Strange Counter problem.
 * The counter starts at 3 and doubles its initial value after each cycle.
 * Each cycle lasts exactly as many seconds as the starting value of that cycle.
 * Given a time 't', the task is to determine the value of the counter at that time.
 * Example:
 * For t = 4, the counter value is 6 (since the first cycle lasts 3 seconds and the second cycle starts at 6).
 * For t = 10, the counter value is 12 (since the third cycle starts at 12).
 * The function strangeCounter(long t) implements this logic efficiently.
 * Time Complexity: O(log t) since the cycle duration doubles each time.
 * Space Complexity: O(1) as only a few variables are used.
 * Example usage is provided in the main method.
 * Author: Rajendra Naik
 */

public class StrangeCounter {

    public static long strangeCounter(long t) {
        // Each cycle starts at a base value (3, 6, 12, 24...)
        // and lasts exactly that many seconds.
        long baseCounter = 3;

        // Jump through cycles until we find the cycle that contains 't'
        while (t > baseCounter) {
            t -= baseCounter; // Subtract the full cycle duration from t
            baseCounter *= 2; // The next cycle's duration doubles
        }

        // Calculate the counter value at the remaining time offset
        return baseCounter - t + 1;
    }

    public static void main(String[] args) {
        int t[] = {1,9,10000};
        for(int n:t) {
            long counter = strangeCounter(n);
            System.out.println("counter:" + counter + " t:" + n);

        }
    }

}
