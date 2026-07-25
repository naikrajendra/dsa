package com.hackerrank.warmup;

import java.util.List;

public class FindMaxConsecutiveUptime {

    public static void main(String[] args) {
        // Sample input data for 5 days
        List<String> uptimeData = List.of("YYY", "YYY", "YNY", "YNN", "YYY");
        System.out.println("Max consecutive days: " + findMaxConsecutiveUptime(uptimeData));
    }

    public static int findMaxConsecutiveUptime(List<String> uptimeData) {
        int maxConsecutiveDays = 0;
        int currentStreak = 0;

        for (String dayStatus : uptimeData) {
            // Check if all microservices are running ('N' is not present)
            if (!dayStatus.contains("N")) {
                currentStreak++;
                // Update the maximum streak found so far
                if (currentStreak > maxConsecutiveDays) {
                    maxConsecutiveDays = currentStreak;
                }
            } else {
                // Break the streak if any microservice is down ('N')
                currentStreak = 0;
            }
        }

        return maxConsecutiveDays;
    }

}
