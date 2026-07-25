package com.hackerrank.warmup;

import java.util.List;

public class DiagonalDifference {
    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     * For example, the square matrix is shown below:
     * 1 2 3
     * 4 5 6
     * 9 8 9
     * The left-to-right diagonal = 1+5+9=1.
     * The right to left diagonal = 3+5+9=17.
     * Their absolute difference is = 15-17=2.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int primarySum = 0;
        int secondarySum = 0;
        int n = arr.size(); // The matrix is square, so rows == columns

        for (int i = 0; i < n; i++) {
            // Primary diagonal: row i, column i
            primarySum += arr.get(i).get(i); // 1,5,9

            // Secondary diagonal: row i, column (n - 1 - i)
            secondarySum += arr.get(i).get(n - 1 - i); // 3,5,9
        }

        // Return the absolute difference
        return Math.abs(primarySum - secondarySum);
    }

}
