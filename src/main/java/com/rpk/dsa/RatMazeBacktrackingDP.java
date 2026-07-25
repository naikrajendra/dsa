package com.rpk.dsa;

import java.util.ArrayList;
import java.util.List;

/**
 * RatMazeBacktrackingDP
 *
 * This class provides a solution to the Rat Maze problem using backtracking
 * with dynamic programming (memoization) to optimize repeated subproblems.
 * 
 */

public class RatMazeBacktrackingDP {

    // Memoization Matrix:
    // 0 = Unvisited
    // 1 = Active path / currently exploring
    // 2 = Verified Dead End (Do not re-explore)
    private int[][] memo;
    private List<String> paths;

    public List<String> findPaths(int[][] maze) {
        paths = new ArrayList<>();
        if (maze == null || maze.length == 0 || maze[0][0] == 0) {
            return paths;
        }

        int n = maze.length;
        memo = new int[n][n];

        // Start backtracking from top-left (0,0) with an empty path string
        backtrack(maze, 0, 0, n, "");
        return paths;
    }

    private void backtrack(int[][] maze, int r, int c, int n, String currentPath) {
        // Base Case: Reached the destination (bottom-right)
        if (r == n - 1 && c == n - 1) {
            paths.add(currentPath);
            return;
        }

        // Boundary, obstacle, active loop, or known dead-end check
        if (r < 0 || r >= n || c < 0 || c >= n || maze[r][c] == 0 || 
            memo[r][c] == 1 || memo[r][c] == 2) {
            return;
        }

        // Mark cell as part of the current recursive path (prevents cycles)
        memo[r][c] = 1;

        // Explore all 4 directions in lexicographical order (Down, Left, Right, Up)
        
        // 1. Move Down ('D')
        backtrack(maze, r + 1, c, n, currentPath + "D");

        // 2. Move Left ('L')
        backtrack(maze, r, c - 1, n, currentPath + "L");

        // 3. Move Right ('R')
        backtrack(maze, r, c + 1, n, currentPath + "R");

        // 4. Move Up ('U')
        backtrack(maze, r - 1, c, n, currentPath + "U");

        // Backtracking state reset: Unmark the cell from active path
        memo[r][c] = 0;

        /* 
         * DP Optimization: If no valid paths were appended from this cell during 
         * the sub-recursion tree, it is a dead end. We cache it to skip future visits.
         */
        if (paths.isEmpty() || !paths.get(paths.size() - 1).startsWith(currentPath)) {
            memo[r][c] = 2; 
        }
    }

    public static void main(String[] args) {
        RatMazeBacktrackingDP solver = new RatMazeBacktrackingDP();
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        };

        List<String> solutions = solver.findPaths(maze);
        System.out.println("All found paths: " + solutions);
    }
}

