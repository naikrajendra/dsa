package com.hackerrank.warmup;

import java.util.ArrayList;
import java.util.List;

public class CavityMap {

    /*
     * Complete the 'cavityMap' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static List<String> cavityMap(List<String> grid) {
    // Write your code here
        List<String> result = new ArrayList<>(grid);
        for(int i=1; i < grid.size()-1; i++) {
            String currentGrid = grid.get(i); //1912
            String upperGrid = grid.get(i-1);//1112
            String lowerGrid = grid.get(i+1);//1892
            
            StringBuilder modifiedRow = new StringBuilder(result.get(i));
            
            for (int j = 1; j < currentGrid.length() - 1; j++) {
                char current = currentGrid.charAt(j);
                
                // Check if the current depth is strictly greater than all 4 neighbors
                if (current > upperGrid.charAt(j) &&     // Top
                    current > lowerGrid.charAt(j) &&     // Bottom
                    current > currentGrid.charAt(j - 1) && // Left
                    current > currentGrid.charAt(j + 1)) { // Right
                    
                    // Replace with 'X'
                    modifiedRow.setCharAt(j, 'X');
                }
            }
        
            // Update the result list with the modified row
            result.set(i, modifiedRow.toString());
        }
        return result;

    }


    public static void main(String[] args) {
        List<String> grid = List.of(
            "1112",
            "1912",
            "1892",
            "1234"
        );
        
        List<String> result = cavityMap(grid);
        for (String row : result) {
            System.out.println(row);
        }   
    }
}
