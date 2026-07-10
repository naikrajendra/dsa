package com.rpk.dsa;

/**
 * This code implements the Insertion Sort algorithm to sort an array of integers.
 * The `insertionSort` method takes an array as input and sorts it in ascending order.
 * The algorithm builds the sorted array one item at a time by repeatedly taking the next item
 * and inserting it into the correct position in the already sorted part of the array.
 * It is efficient for small data sets and mostly sorted arrays, 
 * but it is not suitable for large data sets as its average and 
 * worst-case time complexity is O(n^2).
 * 
 */

public class InsertionSort {

    public void insertionSort(int[] arr) {
        int n = arr.length;

        // Traverse through 1 to n
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements of arr[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        InsertionSort sorter = new InsertionSort();
        int[] arr = {12, 11, 13, 5, 6};
        sorter.insertionSort(arr);
        System.out.println("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
