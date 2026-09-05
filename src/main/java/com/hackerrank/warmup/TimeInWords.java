package com.hackerrank.warmup;

public class TimeInWords {

    /*
     * Complete the 'timeInWords' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     * 1. INTEGER h
     * 2. INTEGER m
     */

    public static String timeInWords(int h, int m) {
        // Array to map numbers 1-29 to words
        String[] words = {
                "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "nineteen", "twenty", "twenty one", "twenty two", "twenty three",
                "twenty four", "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine"
        };

        // Case 1: Exactly on the hour
        if (m == 0) {
            return words[h] + " o' clock";
        }

        // Case 2: Quarter past the hour
        if (m == 15) {
            return "quarter past " + words[h];
        }

        // Case 3: Half past the hour
        if (m == 30) {
            return "half past " + words[h];
        }

        // Case 4: Quarter to the next hour
        if (m == 45) {
            int nextHour = (h % 12) + 1;
            return "quarter to " + words[nextHour];
        }

        // Case 5: Minutes between 1 and 29 (excluding 15)
        if (m < 30) {
            String minuteWord = (m == 1) ? " minute" : " minutes";
            return words[m] + minuteWord + " past " + words[h];
        }

        // Case 6: Minutes between 31 and 59 (excluding 45)
        int remainingMinutes = 60 - m;
        int nextHour = (h % 12) + 1;
        String minuteWord = (remainingMinutes == 1) ? " minute" : " minutes";

        return words[remainingMinutes] + minuteWord + " to " + words[nextHour];
    }

    public static void main(String[] args) {
        int h = 5; // Example hour
        int m = 47; // Example minute
        String result = timeInWords(h, m);
        System.out.println(result);
    }

}
