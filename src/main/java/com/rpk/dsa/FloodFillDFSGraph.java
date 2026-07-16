package com.rpk.dsa;

/**
 * This class provides a method to perform flood fill on a 2D image using depth-first search (DFS).
 * The `floodFill` method changes the color of a pixel and all connected pixels of the same color to a new color.
 * The time complexity of this approach is O(n), where n is the number of pixels in the image, as each pixel is visited at most once.
 * The space complexity is O(h), where h is the height of the recursion stack, which    can be up to O(n) in the worst case for a completely filled image.
 * 
 * FloodFillDFSGraph
 */

public class FloodFillDFSGraph {

    public void floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor != newColor) {
            dfs(image, sr, sc, oldColor, newColor);
        }
    }

    private void dfs(int[][] image, int r, int c, int oldColor, int newColor) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) {
            return;
        }
        if (image[r][c] != oldColor) {
            return;
        }
        image[r][c] = newColor;
        dfs(image, r + 1, c, oldColor, newColor);
        dfs(image, r - 1, c, oldColor, newColor);
        dfs(image, r, c + 1, oldColor, newColor);
        dfs(image, r, c - 1, oldColor, newColor);
    }

    public static void main(String[] args) {
        FloodFillDFSGraph floodFill = new FloodFillDFSGraph();
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1;
        int sc = 1;
        int newColor = 2;

        floodFill.floodFill(image, sr, sc, newColor);

        // Print the modified image
        for (int[] row : image) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }

}
