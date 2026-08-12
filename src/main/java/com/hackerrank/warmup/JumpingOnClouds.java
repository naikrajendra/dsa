package com.hackerrank.warmup;

/**
 * Solution for the "Jumping on the Clouds" problem.
 */

public class JumpingOnClouds {

    /*
     * Complete the 'jumpingOnClouds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY c as parameter.
     */

    static int jumpingOnClouds(int[] c, int k) {
        int n = c.length;
        int energy = 100;
        int i = 0;

        do {
            // Jump by k and wrap around using modulo
            i = (i + k) % n;
            
            // Base cost for jumping
            energy -= 1;
            
            // Extra cost if it's a thundercloud (1)
            if (c[i] == 1) {
                energy -= 2;
            }
        } while (i != 0); // Stop when we loop back to the start

        return energy;
    }

    public static void main(String[] args) {
        int[] c = {0, 0, 1, 0, 0, 1, 0};
        int k = 2; // Example jump distance
        int result = jumpingOnClouds(c, k);
        System.out.println(result); // Expected output: 4
    }

}
