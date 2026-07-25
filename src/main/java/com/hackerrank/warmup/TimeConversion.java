package com.hackerrank.warmup;

public class TimeConversion {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        // Write your code here '12:01:00PM', '12:01:00AM'
        int hour = Integer.parseInt(s.substring(0, 2));

        // Extract the minutes and seconds portion (e.g., ":05:45")
        String minSec = s.substring(2, 8);

        // Extract AM or PM marker
        String ampm = s.substring(8, 10);

        // Handle conversion logic
        if (ampm.equals("AM")) {
            if (hour == 12) {
                hour = 0;
            }
        } else { // It's PM
            if (hour != 12) {
                hour += 12;
            }
        }

        // Format the hour back to a 2-digit string and append the minutes/seconds
        return String.format("%02d%s", hour, minSec);
    }

    private static void runTest(String title, String input, String expected) {
        String actual = timeConversion(input);
        System.out.println("\n" + title);
        System.out.println("Input:    " + input);
        System.out.println("Expected: " + expected);
        System.out.println("Actual:   " + actual);
        System.out.println(actual.equals(expected) ? "PASS" : "FAIL");
    }

    public static void main(String[] args) {
        runTest("Test 1: Midnight start", "12:00:00AM", "00:00:00");
        runTest("Test 2: Noon start", "12:00:00PM", "12:00:00");
        runTest("Test 3: Morning time", "01:05:45AM", "01:05:45");
        runTest("Test 4: Afternoon time", "01:05:45PM", "13:05:45");
        runTest("Test 5: End of day", "11:59:59PM", "23:59:59");
    }

}
