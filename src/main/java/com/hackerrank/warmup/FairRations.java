package com.hackerrank.warmup;

import java.util.ArrayList;
import java.util.List;

public class FairRations {

    public static String fairRations(List<Integer> B) {
        List<Integer> workingList = new ArrayList<>(B);
        int noOfLoavesReqd = 0;
        int len = workingList.size();

        // Loop up to the second-to-last person (len - 1)
        for (int i = 0; i < len - 1; i++) {
            int currBreadCount = workingList.get(i);

            // If the current person has an odd number of loaves
            if (currBreadCount % 2 != 0) {
                // Give a loaf to the current person and the next person
                workingList.set(i, currBreadCount + 1);
                workingList.set(i + 1, workingList.get(i + 1) + 1);

                noOfLoavesReqd += 2;
            }
        }

        // After the loop, check only the very last person.
        // If the last person is odd, it's impossible to balance the line.
        if (workingList.get(len - 1) % 2 != 0) {
            return "NO";
        }

        return String.valueOf(noOfLoavesReqd);
    }

    public static void main(String[] args) {
        List<Integer> B = List.of(2, 3, 4, 5, 6); // Example input
        String result = fairRations(B);
        System.out.println(result);
    }

}
