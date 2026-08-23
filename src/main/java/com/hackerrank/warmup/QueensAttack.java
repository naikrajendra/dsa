package com.hackerrank.warmup;

import java.util.Arrays;
import java.util.List;

public class QueensAttack {

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        // 1. Calculate max possible distance to the board edges in all 8 directions
        int up    = n - r_q;
        int down  = r_q - 1;
        int right = n - c_q;
        int left  = c_q - 1;
        
        int upRight   = Math.min(up, right);
        int upLeft    = Math.min(up, left);
        int downRight = Math.min(down, right);
        int downLeft  = Math.min(down, left);

        // 2. Iterate through each obstacle once and shrink the paths
        for (int i = 0; i < k; i++) {
            List<Integer> obstacle = obstacles.get(i);
            int r_o = obstacle.get(0);
            int c_o = obstacle.get(1);

            // Check if the obstacle is on the same row, column, or diagonals
            if (c_o == c_q) { // Vertical alignment (Up / Down)
                if (r_o > r_q) {
                    up = Math.min(up, r_o - r_q - 1);
                } else {
                    down = Math.min(down, r_q - r_o - 1);
                }
            } 
            else if (r_o == r_q) { // Horizontal alignment (Right / Left)
                if (c_o > c_q) {
                    right = Math.min(right, c_o - c_q - 1);
                } else {
                    left = Math.min(left, c_q - c_o - 1);
                }
            } 
            else if (Math.abs(r_o - r_q) == Math.abs(c_o - c_q)) { // Diagonal alignment
                if (r_o > r_q && c_o > c_q) { // Up-Right
                    upRight = Math.min(upRight, r_o - r_q - 1);
                } else if (r_o > r_q && c_o < c_q) { // Up-Left
                    upLeft = Math.min(upLeft, r_o - r_q - 1);
                } else if (r_o < r_q && c_o > c_q) { // Down-Right
                    downRight = Math.min(downRight, r_q - r_o - 1);
                } else if (r_o < r_q && c_o < c_q) { // Down-Left
                    downLeft = Math.min(downLeft, r_q - r_o - 1);
                }
            }
        }

        // 3. Sum up the remaining valid attackable squares
        return up + down + right + left + upRight + upLeft + downRight + downLeft;
    }
    
    public static void main(String[] args) {
        int n = 8; // Board size
        int k = 1; // Number of obstacles
        int r_q = 4; // Queen's row
        int c_q = 4; // Queen's column
        List<List<Integer>> obstacles = Arrays.asList(
                Arrays.asList(3, 5)
        ); // Obstacles positions

        int result = queensAttack(n, k, r_q, c_q, obstacles);
        System.out.println(result); // Expected output: 27
    }

}
