package com.hackerrank.warmup;

/**
 * 
 * This class compares the scores of Alice and Bob in a triplet format.
 * Each triplet consists of three scores, and the comparison is done
 * element-wise.
 * Alice and Bob each created one problem for HackerRank. A reviewer rates the
 * two challenges, awarding points on a scale from 1 to 100 for three
 * categories: problem clarity, originality, and difficulty.
 * The rating for Alice's challenge is the triplet a = (a[0], a[1], a[2]), and
 * the rating for Bob's challenge is the triplet b = (b[0], b[1], b[2]).
 * The task is to calculate their comparison points by comparing each category:
 *
 * If a[i] > b[i], then Alice is awarded 1 point.
 * If a[i] < b[i], then Bob is awarded 1 point.
 * If a[i] = b[i], then neither person receives a point.
 */

public class CompareTriplets {

    public static void main(String[] args) {
        // Sample input data for Alice and Bob's scores
        int[] aliceScores = { 5, 6, 7 };
        int[] bobScores = { 3, 6, 10 };

        int[] result = compareTriplets(aliceScores, bobScores);
        System.out.println("Alice's score: " + result[0] + ", Bob's score: " + result[1]);
    }

    public static int[] compareTriplets(int[] a, int[] b) {
        int aliceScore = 0;
        int bobScore = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > b[i]) {
                aliceScore++;
            } else if (a[i] < b[i]) {
                bobScore++;
            }
            // If scores are equal, no points are awarded
        }

        return new int[] { aliceScore, bobScore };
    }
}
