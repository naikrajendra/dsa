package com.rpk.dsa;

/***
 * This class provides a method to calculate the minimum path sum in a grid using a space-optimized dynamic programming approach.
 * The `minPathSum` method computes the minimum path sum from the top-left corner to the bottom-right corner of a 2D grid, where each cell contains a non-negative integer. The time complexity of this approach is O(m * n), where m is the number of rows and n is the number of columns in the grid. The space complexity is O(n), as we use a 1D array to store the minimum path sums for the current row.
 * Example usage is provided in the `main` method, which calculates and prints the minimum path sum for given input grids.
 * 
 * 
 * MinimumPathSumSpaceOptimized
 */

public class MinimumPathSumSpaceOptimized {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        // Create a 1D array to store the minimum path sums for the current row
        int[] dp = new int[cols];

        // Initialize the first cell
        dp[0] = grid[0][0];

        // Fill the first row
        for (int j = 1; j < cols; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }

        // Iterate through the rest of the rows
        for (int i = 1; i < rows; i++) {
            // Update the first column for the current row
            dp[0] += grid[i][0];

            // Update the rest of the columns for the current row
            for (int j = 1; j < cols; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }

        // The last cell contains the minimum path sum to reach the bottom-right corner
        return dp[cols - 1];
    }

    public static void main(String[] args) {
        MinimumPathSumSpaceOptimized minPathSumSolver = new MinimumPathSumSpaceOptimized();
        int[][] grid1 = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
        System.out.println(minPathSumSolver.minPathSum(grid1)); // Output: 7

        int[][] grid2 = {
            {1, 2, 3},
            {4, 5, 6}
        };
        System.out.println(minPathSumSolver.minPathSum(grid2)); // Output: 12
    }

}
