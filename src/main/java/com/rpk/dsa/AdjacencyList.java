package com.rpk.dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This class represents an adjacency list for an undirected graph.
 * It provides methods to add, remove, and check edges between vertices.
 * The adjacency list is an array of linked lists, where each index represents a
 * vertex and the linked list at that index contains the vertices adjacent to
 * it.
 * The time complexity for adding and removing edges is O(1) on average, while
 * checking
 * for the existence of an edge is O(k), where k is the number of adjacent
 * vertices for a given vertex.
 * The space complexity is O(V + E), where V is the number of vertices and E is
 * the number of edges in the graph, due to the storage of the adjacency list.
 * 
 * AdjacencyList
 */

public class AdjacencyList {

    private int vertices;
    private List<List<Integer>> adjacencyList;

    public AdjacencyList(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new LinkedList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source); // For undirected graph
    }

    public void removeEdge(int source, int destination) {
        adjacencyList.get(source).remove(Integer.valueOf(destination));
        adjacencyList.get(destination).remove(Integer.valueOf(source)); // For undirected graph
    }

    public boolean hasEdge(int source, int destination) {
        return adjacencyList.get(source).contains(destination);
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + ":");
            for (Integer neighbor : adjacencyList.get(i)) {
                System.out.print(" -> " + neighbor);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AdjacencyList graph = new AdjacencyList(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println("Adjacency List:");
        graph.printGraph();

        System.out.println("Has edge between 0 and 1: " + graph.hasEdge(0, 1)); // true
    }

}
