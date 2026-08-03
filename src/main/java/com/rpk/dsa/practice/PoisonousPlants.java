package com.rpk.dsa.practice;

/**
 * PoisonousPlants
 *
 * This class contains a method to determine the number of days after which no plants die.
 * Enumerate through the array of plants, and for each plant, check if it has a higher pesticide level than the plant to its left.
 * If it does, it will die the next day. Keep track of the number of days until no plants die, and return that count.
 * 
 */

public class PoisonousPlants {

    public static int poisonousPlants(int[] p) {
        int days = 0;
        boolean plantsDied = true;

        while (plantsDied) {
            plantsDied = false;
            int[] newP = new int[p.length];
            newP[0] = p[0];
            int j = 1;

            for (int i = 1; i < p.length; i++) {
                if (p[i] <= p[i - 1]) {
                    newP[j++] = p[i];
                } else {
                    plantsDied = true;
                }
            }

            p = new int[j];
            System.arraycopy(newP, 0, p, 0, j);
            if (plantsDied) {
                days++;
            }
        }

        return days;
    }

    public static void main(String[] args) {
        int[] plants = {6, 5, 8, 4, 7, 10, 9};
        System.out.println(poisonousPlants(plants));
    }
}
