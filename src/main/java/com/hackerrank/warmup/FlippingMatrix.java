package com.hackerrank.warmup;

import java.util.List;

/**
 * https://www.hackerrank.com/challenges/flipping-the-matrix/problem
 */
public class FlippingMatrix {

    public static int flippingMatrix(List<List<Integer>> matrix) {
        int sum = 0;
        int size = matrix.size();
        int n = size / 2;

        // Loop through the upper-left n x n quadrant
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Find the four mirrored positions for the current cell
                int topLeft = matrix.get(i).get(j);
                int topRight = matrix.get(i).get(size - 1 - j);
                int bottomLeft = matrix.get(size - 1 - i).get(j);
                int bottomRight = matrix.get(size - 1 - i).get(size - 1 - j);

                // Select the maximum value among the four symmetric options
                int maxVal = Math.max(Math.max(topLeft, topRight), Math.max(bottomLeft, bottomRight));

                // Accumulate the maximum values
                sum += maxVal;
            }
        }
        return sum;
    }

}
