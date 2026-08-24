package com.hackerrank.warmup;

import java.util.Arrays;
import java.util.List;

public class AcmTeam {

    public static List<Integer> acmTeam(List<String> topic) {
        int n = topic.size();
        int m = topic.get(0).length();
        int maxTopics = 0;
        int teamCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int topics = 0;
                for (int k = 0; k < m; k++) {
                    if (topic.get(i).charAt(k) == '1' || topic.get(j).charAt(k) == '1') {
                        topics++;
                    }
                }
                if (topics > maxTopics) {
                    maxTopics = topics;
                    teamCount = 1;
                } else if (topics == maxTopics) {
                    teamCount++;
                }
            }
        }
        return Arrays.asList(maxTopics, teamCount);
    }

    public static void main(String[] args) {
        List<String> topic = Arrays.asList("10101", "11100", "11010", "00101");
        List<Integer> result = acmTeam(topic);
        System.out.println("Max Topics: " + result.get(0));
        System.out.println("Team Count: " + result.get(1));
    }
}
