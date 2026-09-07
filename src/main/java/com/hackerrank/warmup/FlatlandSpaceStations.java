package com.hackerrank.warmup;

import java.util.Arrays;

/**
 * Solution to the Flatland Space Stations problem.
 * Given the number of cities and the locations of space stations,
 * this program calculates the maximum distance any city is from the nearest space station.
 * Example usage is provided in the main method.
 * @author Rajendra
 * @version 1.0
 * @since 2024-06
 * FlatlandSpaceStations
 */
public class FlatlandSpaceStations {

    static int flatlandSpaceStations(int n, int[] c) {
        // Sort the space stations to easily find adjacent stations
        Arrays.sort(c);
        
        // 1. Handle the boundary case: distance from city 0 to the first space station
        int maxDistance = c[0];
        
        // 2. Handle middle cases: max distance between any two adjacent space stations
        for (int i = 1; i < c.length; i++) {
            int distanceBetweenStations = c[i] - c[i - 1];
            // The city right in the middle of two stations is the furthest away
            int distanceToNearest = distanceBetweenStations / 2; 
            maxDistance = Math.max(maxDistance, distanceToNearest);
        }
        
        // 3. Handle the boundary case: distance from the last space station to the last city (n - 1)
        int lastStationDistance = (n - 1) - c[c.length - 1];
        maxDistance = Math.max(maxDistance, lastStationDistance);
        
        return maxDistance;
    }

    public static void main(String[] args) {
        int n = 5; // Example number of cities
        int[] c = {0, 4}; // Example space stations
        int result = flatlandSpaceStations(n, c);
        System.out.println(result);
    }
}
