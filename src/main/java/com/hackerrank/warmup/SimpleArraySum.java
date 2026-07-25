package com.hackerrank.warmup;

import java.util.List;

public class SimpleArraySum {
    /*
     * Complete the 'simpleArraySum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY ar as parameter.
     */

    public static int simpleArraySum(List<Integer> ar) {
        // Write your code here
        int n = ar.size();
        int left = 0;
        int right = n - 1;
        int sum = 0;
        while (left < right) {
            sum = sum + ar.get(left) + ar.get(right);
            left++;
            right--;
        }

        return sum;

    }

    public static void main(String[] args) {
        List<Integer> ar = List.of(1, 2, 3, 4, 10);
        System.out.println(simpleArraySum(ar));
    }

}
