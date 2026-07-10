package com.rpk.dsa;

/**
 * This code implements the Bubble Sort algorithm to sort an array of integers.
 * The `bubbleSort` method takes an array as input and sorts it in ascending order.
 * The algorithm repeatedly steps through the list, compares adjacent elements and swaps them
 * if they are in the wrong order. The process is repeated until the list is sorted.
 * An optimization is included to stop the algorithm if no swaps were made, 
 * indicating that the array is already sorted.
 */

public class BubbleSort {

    public void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        // Traverse through all elements in the array
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Last i elements are already in place, no need to check them
            for (int j = 0; j < n - i - 1; j++) {
                // Swap if the element found is greater than the next element
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were swapped, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort sorter = new BubbleSort();
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        sorter.bubbleSort(arr);
        System.out.println("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }


}
