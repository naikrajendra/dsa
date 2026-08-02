package com.hackerrank.warmup;

/**
 * BudgetMoneySpent
 *
 * This class contains a method to determine the maximum amount of money
 * that can be spent on a keyboard and a drive without exceeding a given budget.
 */

public class BudgetMoneySpent {

    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        /*
         * Write your code here.
         */
        int maxMoneySpent = -1;
        int moneySpent = 0;
        //loop through keyboards
        //loop through drives
        // find the max below value b
        // b=60
        //[40,50,60]
        //[5,8,12]
        for(int keyboard: keyboards) {
            for(int drive: drives) {
                //40+5=45,40+8=48,40+12=52,50+5=55,50+8=58,60+5=65,60+8=68,60+12=72
                moneySpent = keyboard + drive;
                if(moneySpent <= b) {
                    //45,48,52,55,58
                    maxMoneySpent = Math.max(maxMoneySpent, moneySpent);
                }
            }
        }
        return maxMoneySpent;  //58      
    }

    public static void main(String[] args) {
        int[] keyboards = {40, 50, 60};
        int[] drives = {5, 8, 12};
        int b = 60;
        System.out.println(getMoneySpent(keyboards, drives, b));
    }

}
