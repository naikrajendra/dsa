package com.rpk.dsa;

/**
 * This class provides a method to find the shortest path from a source vertex to all other vertices in a weighted graph using Dijkstra's algorithm.
 * The `dijkstraAlgorithm` method uses a greedy approach to iteratively select the vertex with the minimum distance from the source and updates the distances of its adjacent vertices.
 * The time complexity of this approach is O(V^2), where V is the number of vertices in the graph, due to the nested loops for finding the minimum distance and updating adjacent vertices. The space complexity is O(V), as it requires storage for the distance and visited arrays.   
 * 
 * DijkstraAlgorithm
 */

public class DijkstraAlgorithm {

    public void dijkstraAlgorithm(int[][] graph, int source) {
        int n = graph.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        dist[source] = 0;

        for (int i = 0; i < n - 1; i++) {
            int u = minDistance(dist, visited);
            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        printSolution(dist);
    }

    private int minDistance(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < dist.length; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    private void printSolution(int[] dist) {
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < dist.length; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }   

    public static void main(String[] args) {
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm();
        int[][] graph = {
                {0, 7, 9, 0, 0, 14},
                {7, 0, 10, 15, 0, 0},
                {9, 10, 0, 11, 0, 2},
                {0, 15, 11, 0, 6, 0},
                {0, 0, 0, 6, 0, 9},
                {14, 0, 2, 0, 9, 0}
        };
        int source = 0;
        dijkstra.dijkstraAlgorithm(graph, source);
    }


}
