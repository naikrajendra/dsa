package com.rpk.dsa;

/**
 * This class represents an adjacency matrix for an undirected graph.
 * It provides methods to add, remove, and check edges between vertices.
 * The adjacency matrix is a 2D array where the element at row i and column j is 1 if there is an edge between vertex i and vertex j, and 0 otherwise.
 * The time complexity for adding, removing, and checking edges is O(1), as these operations involve direct access to the matrix elements.
 * The space complexity is O(n^2), where n is the number of vertices in the graph, due to the storage of the adjacency matrix.  
 *  
 * AdjacencyMatrix
 */

public class AdjecencyMatrix {

    private int[][] matrix;
    private int size;

    public AdjecencyMatrix(int size) {
        this.size = size;
        matrix = new int[size][size];
    }

    public void addEdge(int i, int j) {
        matrix[i][j] = 1;
        matrix[j][i] = 1; // For undirected graph
    }

    public void removeEdge(int i, int j) {
        matrix[i][j] = 0;
        matrix[j][i] = 0; // For undirected graph
    }

    public boolean hasEdge(int i, int j) {
        return matrix[i][j] == 1;
    }

    public void printMatrix() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AdjecencyMatrix graph = new AdjecencyMatrix(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println("Adjacency Matrix:");
        graph.printMatrix();

        System.out.println("Has edge between 0 and 1: " + graph.hasEdge(0, 1)); // true
        System.out.println("Has edge between 0 and 2: " + graph.hasEdge(0, 2)); // false

        graph.removeEdge(0, 1);
        System.out.println("Has edge between 0 and 1 after removal: " + graph.hasEdge(0, 1)); // false
    }

}
