package com.hackerrank.warmup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Determines if it is possible to organize containers such that each container contains balls of only one type.
 * Returns "Possible" if it can be done, otherwise returns "Impossible".
 * 
 * OrganizingContainers
 */

public class OrganizingContainers {

    public static String organizingContainers(List<List<Integer>> container) {
        int n = container.size();
        int[] rowSum = new int[n];
        int[] colSum = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i] += container.get(i).get(j);
                colSum[j] += container.get(i).get(j);
            }
        }

        Arrays.sort(rowSum);
        Arrays.sort(colSum);

        for (int i = 0; i < n; i++) {
            if (rowSum[i] != colSum[i]) {
                return "Impossible";
            }
        }
        return "Possible";
    }

    public static void main(String[] args) {
        List<List<Integer>> container = new ArrayList<>();
        container.add(Arrays.asList(1, 1));
        container.add(Arrays.asList(1, 1));

        String result = organizingContainers(container);
        System.out.println(result);
    }
}
