package com.rpk.dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * This class provides a method to perform Topological Sort on a
 * directed acyclic graph (DAG) using Kahn's algorithm. The `topologicalSort` 
 * method computes the topological order of vertices by calculating in-degrees, using a queue to process vertices with zero in-degrees, and reducing in-degrees of neighboring vertices. The time complexity of this approach is O(V + E), where V is the number of vertices and E is the number of edges. The space complexity is O(V) for storing the in-degrees and the result list.
 * 
 * TopologicalSort
 */

public class TopologicalSort {
    
    // Function to perform Topological Sort
    public static List<Integer> topologicalSort(int vertices, List<List<Integer>> adj) {
        int[] inDegree = new int[vertices];
        
        // 1. Calculate in-degrees (number of incoming edges) for all vertices
        for (int i = 0; i < vertices; i++) {
            for (int neighbor : adj.get(i)) {
                inDegree[neighbor]++;
            }
        }
        
        // 2. Queue all vertices with an in-degree of 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertices; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        List<Integer> topoOrder = new ArrayList<>();
        
        // 3. Process the vertices
        while (!queue.isEmpty()) {
            int current = queue.poll();
            topoOrder.add(current);
            
            // Reduce in-degree for all neighboring vertices
            for (int neighbor : adj.get(current)) {
                inDegree[neighbor]--;
                
                // If in-degree becomes 0, add it to the queue
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        
        // 4. Check for cycles (if topoOrder size doesn't match total vertices)
        if (topoOrder.size() != vertices) {
            System.out.println("The graph contains a cycle! Topological sort is impossible.");
            return new ArrayList<>(); // Return empty list
        }
        
        return topoOrder;
    }

    public static void main(String[] args) {
        int vertices = 6;
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Define directed edges (e.g., 5 -> 2, 5 -> 0, etc.)
        graph.get(5).add(2);
        graph.get(5).add(0);
        graph.get(4).add(0);
        graph.get(4).add(1);
        graph.get(2).add(3);
        graph.get(3).add(1);
        
        System.out.println("Topological Sort Order:");
        List<Integer> result = topologicalSort(vertices, graph);
        System.out.println(result);
    }        



}
