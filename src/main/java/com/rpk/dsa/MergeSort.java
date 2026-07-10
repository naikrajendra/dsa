package com.rpk.dsa;

/**
 * This code implements the Merge Sort algorithm to sort an array of integers.
 * The `mergeSort` method takes an array as input and sorts it in ascending order.
 * The algorithm follows a divide-and-conquer approach by recursively splitting the array into two halves,
 * sorting each half, and then merging the sorted halves back together.
 * The `merge` method is responsible for merging two sorted arrays into a single sorted array.
 * Merge Sort has a time complexity of O(n log n) and is efficient for large data sets, but it requires additional space for the temporary arrays used during the merge process.    
 * 
 */

public class MergeSort {

    public void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return; // Base case: arrays with less than 2 elements are already sorted
        }

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        // Split the array into two halves
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < arr.length; i++) {
            right[i - mid] = arr[i];
        }

        // Recursively sort both halves
        mergeSort(left);
        mergeSort(right);

        // Merge the sorted halves
        merge(arr, left, right);
    }   
    
    private void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Merge the two arrays while maintaining sorted order
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Copy any remaining elements from the left array
        while (i < left.length) {
            arr[k++] = left[i++];
        }

        // Copy any remaining elements from the right array
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        MergeSort sorter = new MergeSort();
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        sorter.mergeSort(arr);
        System.out.println("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}
