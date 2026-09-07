package com.hackerrank.warmup;

import java.util.List;

/**
 * Determines the number of special problems in a workbook.
 * A problem is considered special if its index within the chapter matches the page number it appears on.
 * 
 * Workbook
 */

public class Workbook {

    public static int workbook(int n, int k, List<Integer> arr) {
        int numSpecialProblems = 0;
        int pageCount = 0;
        
        for (int i = 0; i < arr.size(); i++) {
            int totalProblemsInChapter = arr.get(i);
            
            // Track the actual 1-based problem numbers for the current page
            int startProblem = 1;
            
            while (startProblem <= totalProblemsInChapter) {
                pageCount++; // Move to the next page
                
                // The end problem is either the start + k - 1, or capped at total problems
                int endProblem = Math.min(startProblem + k - 1, totalProblemsInChapter);
                
                // Check if the current page number falls within the problem range of this page
                if (pageCount >= startProblem && pageCount <= endProblem) {
                    numSpecialProblems++;
                }
                
                // Advance to the start of the next page's problems
                startProblem += k;
            }
        }
        
        return numSpecialProblems;
    }

    public static void main(String[] args) {
        // Example input
        int n = 5; // Number of chapters
        int k = 3; // Maximum number of problems per page
        List<Integer> arr = List.of(4, 2, 6, 1, 10); // Number of problems in each chapter

        int result = workbook(n, k, arr);
        System.out.println(result);
    }
}
