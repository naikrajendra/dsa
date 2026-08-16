package com.hackerrank.warmup;

/**
 * Solution for the "Library Fine" problem.
 * 
 * LibraryFine
 */

public class LibraryFine {
    /*
    public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
    // Write your code here
        //check the year is same
        //check if month is same
        //check the difference between days
        //calculate fine
        // 2,7,1014
        // 1,1,1015
        int fine = 0;
        int yearDiff = y1 - y2; //-1
        int monthDiff = m1 - m2; //7-1=6
        int daysDiff = d1-d2;//2-1=1
        if(yearDiff > 0) {
            fine = 10000;
            return fine;
        }
        else if(yearDiff >= 0 && monthDiff > 0) {//-1,6
            fine = monthDiff * 500;
            return fine;
        } else if(yearDiff >= 0 && monthDiff >= 0 && daysDiff > 0) {//-1,6,1
            fine = daysDiff * 15;
            return fine;
        }
        return fine; 
    } */

    /**
     * Calculates the library fine based on the return date and due date.
     *
     * @param d1 the day of the return date
     * @param m1 the month of the return date
     * @param y1 the year of the return date
     * @param d2 the day of the due date
     * @param m2 the month of the due date
     * @param y2 the year of the due date
     * @return the calculated fine
     */
    public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        // Write your code here
        if (y1 > y2) {
            return 10000;
        } else if (y1 == y2 && m1 > m2) {
            return (m1 - m2) * 500;
        } else if (y1 == y2 && m1 == m2 && d1 > d2) {
            return (d1 - d2) * 15;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int d1 = 2; // Example input
        int m1 = 7; // Example input
        int y1 = 1014; // Example input
        int d2 = 1; // Example input
        int m2 = 1; // Example input
        int y2 = 1015; // Example input
        int result = libraryFine(d1, m1, y1, d2, m2, y2);
        System.out.println(result); // Expected output: 0
    }
}
