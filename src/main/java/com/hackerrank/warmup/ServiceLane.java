package com.hackerrank.warmup;

import java.util.ArrayList;
import java.util.List;

/**
 * Determines the minimum width of the service lane for each test case.
 * The service lane is represented by an array of widths, and each test case specifies
 * the entry and exit indices of the segment to consider.
 * 
 * ServiceLane
 */
public class ServiceLane {
    
    public static List<Integer> serviceLane(int n, List<Integer> width, List<List<Integer>> cases) {
        // This list will store the result for each individual case
        List<Integer> result = new ArrayList<>();

        // Loop through each test case
        for (int i = 0; i < cases.size(); i++) {
            // Extract the sublist representing the current case (e.g., [entry_index,
            // exit_index])
            List<Integer> currentCase = cases.get(i);

            int entry = currentCase.get(0);
            int exit = currentCase.get(1);

            // Initialize the minimum width to the largest possible size (3 is the max width
            // in this problem)
            int minWidth = 3;

            // Loop from the entry index to the exit index (inclusive) to find the
            // bottleneck width
            for (int j = entry; j <= exit; j++) {
                minWidth = Math.min(minWidth, width.get(j));
            }

            // Add the bottleneck width of the current segment to our results list
            result.add(minWidth);
        }

        return result;
    }

    public static void main(String[] args) {
        // Example input
        int n = 8; // Length of the service lane
        List<Integer> width = List.of(2, 3, 1, 2, 3, 2, 3, 3); // Widths of each segment
        List<List<Integer>> cases = List.of(
                List.of(0, 3),
                List.of(4, 6),
                List.of(6, 7));

        // Call the serviceLane function and print the results
        List<Integer> result = serviceLane(n, width, cases);
        for (int r : result) {
            System.out.println(r);
        }
    }
}
