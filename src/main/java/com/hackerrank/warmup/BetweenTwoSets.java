package com.hackerrank.warmup;

public class BetweenTwoSets {

    public static int getTotalX(int[] a, int[] b) {
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            boolean isFactorOfAllA = true;
            for (int j = 0; j < a.length; j++) {
                if (i % a[j] != 0) {
                    isFactorOfAllA = false;
                    break;
                }
            }
            if (!isFactorOfAllA) {
                continue;
            }
            boolean isFactorOfAllB = true;
            for (int j = 0; j < b.length; j++) {
                if (b[j] % i != 0) {
                    isFactorOfAllB = false;
                    break;
                }
            }
            if (isFactorOfAllB) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {2, 4};
        int[] b = {16, 32, 96};
        System.out.println(getTotalX(a, b));
    }

    
}
