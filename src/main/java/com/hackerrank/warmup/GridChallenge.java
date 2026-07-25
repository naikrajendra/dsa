package com.hackerrank.warmup;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * *
 * * e f g
 * 
 * 
 * 
 * 
 * * g are also in alp
 * 
 * * row.
 * 
 * * Function Description
 * 
 * * Complete the gridChallenge funct
 * *
 * 
 * *
 * * string gr
 * 
 * *
 * 
 * * Input Format
 * *
 * * The fir line contains , the number of te
 * 
 * * Each of
 * 
 * 
 * 
 * * Constraints
 * 
 * *
 * 
 * * Each string consists of lowercase letters in the range ascii[a-z]
 * 
 * 
 * 
 * * Ou
 * *
 * * Fo
 * * rearrange
 * 
 * *
 * * Sampl
 * 
 * * xywuv
 * 
 * *
 * * YE
 * * Ex
 * *
 * * Th
 * *
 * 
 * 
 * 
 * pqrst
 * uvwxy
 * This fulfills the condition since the rows 1, 2, ..., 5 and the columns 1, 2,
 * ..., 5 are all alphabetically sorted.
 */

public class GridChallenge {

    /*
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */
    public static String gridChallenge(List<String> grid) {
    // Write your code here
        // find rows and columns count

        // sort columns
        // See if Arrays.sort() be used
        // time complexity O(RxCLogC)
        // space complexity O()
        int rows = grid.size();
        int cols = grid.get(0).length();
        
        // Step 1: Sort every row alphabetically
        char[][] sortedGrid = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            char[] rowChars = grid.get(i).toCharArray();
            Arrays.sort(rowChars);
            sortedGrid[i] = rowChars;
        }

        // Step 2: Check if each column is sorted from top to bottom
        for (int col = 0; col < cols; col++) {
            for (int row = 1; row < rows; row++) {
                // If a character is alphabetically smaller than the one above it, it fails
                if (sortedGrid[row][col] < sortedGrid[row - 1][col]) {
                    return "NO";
                 }
    // 
            }
        }

        return "YES";
    }

    public static void main(String[] args) {
        List<String> grid = List.of("abc", "ade", "efg");
        String result = gridChallenge(grid);
        System.out.println(result); // Expected output: "YES"
    }
}