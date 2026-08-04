package com.hackerrank.warmup;

import java.util.ArrayList;
import java.util.List;

/**
 * ClimbingLeaderboard
 *
 * This class contains a method to determine the player's rank on a leaderboard
 * after each game, given the current ranked scores and the player's scores.
 */

public class ClimbingLeaderboard {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) 
    {
        List<Integer> playerRanks = new ArrayList<>();
        
        // Step 1: Remove duplicates from 'ranked' to get distinct scores
        List<Integer> distinctRanked = new ArrayList<>();
        for (int score : ranked) {
            if (distinctRanked.isEmpty() || distinctRanked.get(distinctRanked.size() - 1) != score) {
                distinctRanked.add(score);
            }
        }
        
        // Step 2: Use a single pointer walking backwards from the lowest rank
        int leaderboardIndex = distinctRanked.size() - 1;
        
        for (int playerGameScore : player) {
            // Move up the leaderboard while the player's score is higher or equal
            while (leaderboardIndex >= 0 && 
                playerGameScore >= distinctRanked.get(leaderboardIndex)) {
                leaderboardIndex--;
            }
            
            // The rank is the index position + 2 (since index is 0-based and we went 1 step too far)
            playerRanks.add(leaderboardIndex + 2);
        }
        
        return playerRanks;
    }

    public static void main(String[] args) {
        List<Integer> ranked = List.of(100, 90, 90, 80, 75, 60);
        List<Integer> player = List.of(50, 65, 77, 90, 102);
        
        List<Integer> result = climbingLeaderboard(ranked, player);
        System.out.println(result); // Expected output: [6, 5, 4, 2, 1]
    }
}
