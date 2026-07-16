package com.rpk.dsa;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This class provides a method to determine the minimum number of minutes that must elapse until no cell has a fresh orange using breadth-first search (BFS).
 * The `orangesRotting` method uses a multi-source BFS approach to simulate the rotting process of oranges in a grid. It starts from all initially rotten oranges and spreads the rot to adjacent fresh oranges minute by minute.
 * The time complexity of this approach is O(n), where n is the total number of cells in the grid, as each cell is processed at most once. The space complexity is O(n) in the worst case, where all oranges are rotten and stored in the queue.
 * 
 * RottenOrangesGraphBFS
 */

public class RottenOrangesGraphBFS {

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        
        // Step 1: Count fresh oranges and add all rotten oranges to the queue
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }
        
        // Step 2: If there are no fresh oranges initially, return 0
        if (freshCount == 0) return 0;
        
        int minutes = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        // Step 3: Perform Multi-source BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedThisMinute = false;
            
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];
                
                // Check all 4 adjacent directions
                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    
                    // If the adjacent cell contains a fresh orange, make it rotten
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2; // Mark as rotten
                        queue.offer(new int[]{nr, nc});
                        freshCount--; // Decrease fresh orange count
                        rottedThisMinute = true;
                    }
                }
            }
            
            // Only increment time if at least one fresh orange rotted this minute
            if (rottedThisMinute) {
                minutes++;
            }
        }
        
        // Step 4: If all fresh oranges have rotted, return the time. Otherwise, return -1.
        return freshCount == 0 ? minutes : -1;
    }    

    public static void main(String[] args) {
        RottenOrangesGraphBFS solution = new RottenOrangesGraphBFS();
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        
        int result = solution.orangesRotting(grid);
        System.out.println("Minutes until all oranges rot: " + result); // Output: 4
    }

}
