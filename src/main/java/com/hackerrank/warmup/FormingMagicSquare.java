package com.hackerrank.warmup;

import java.util.Arrays;
import java.util.List;

/**
 * FormingMagicSquare
 *
 * This class contains a method to determine the minimum cost to convert a
 * 3x3 matrix into a magic square.
 * 
 */

public class FormingMagicSquare {

    /*
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */

    public static int formingMagicSquare(List<List<Integer>> s) {
    // Write your code here
        int[] costs = new int[8];
        
        // All 8 possible 3x3 magic squares
        int[][][] magicSquares = {
            {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
            {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
            {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
            {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
            {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},
            {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
            {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
            {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}}
        };
        
        for (int k = 0; k < 8; k++) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int inputVal = s.get(i).get(j);
                    costs[k] += Math.abs(inputVal - magicSquares[k][i][j]);
                }
            }
        }
        
        Arrays.sort(costs);
        return costs[0];    
    }

    public static void main(String[] args) {
        List<List<Integer>> s = List.of(
            List.of(4, 9, 2),
            List.of(3, 5, 7),
            List.of(8, 1, 5)
        );
        System.out.println(formingMagicSquare(s));
    }



}
