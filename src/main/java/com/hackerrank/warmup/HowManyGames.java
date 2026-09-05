package com.hackerrank.warmup;

/**
 * Determines the maximum number of games that can be purchased given the initial price, discount, minimum price, and total budget.
 * 
 * HowManyGames
 */
public class HowManyGames {

    public static int howManyGames(int p, int d, int m, int s) {
        int numberOfGamesPurchased = 0;
        int currGameAmount = p; // Start with the initial price

        // Keep buying while we can afford the current game price
        while (s >= currGameAmount) {
            s -= currGameAmount; // Deduct the game price from total budget
            numberOfGamesPurchased++; // Increment the purchase count

            // Calculate the price for the next game
            if (currGameAmount - d > m) {
                currGameAmount = currGameAmount - d;
            } else {
                currGameAmount = m;
            }
        }

        return numberOfGamesPurchased;
    }

    public static void main(String[] args) {
        int p = 20; // Initial price of the game
        int d = 3; // Discount per subsequent game
        int m = 6; // Minimum price of the game
        int s = 80; // Total budget

        int result = howManyGames(p, d, m, s);
        System.out.println(result);
    }

}
