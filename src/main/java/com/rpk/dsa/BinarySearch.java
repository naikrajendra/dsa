package com.rpk.dsa;

/**
 * This class provides a method to perform binary search on a sorted array.
 * The `binarySearch` method uses an iterative approach to find the index of a target value in the array. If the target value is found, it returns the index; otherwise, it returns -1.
 * The time complexity of this approach is O(log n), where n is the number of elements in the array, as the search space is halved with each iteration. 
 * The space complexity is O(1), as it uses a constant amount of space for variables regardless of the input size.  
 * 
 * BinarySearch
 */

public class BinarySearch {

    public int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // Target found at index mid
            } else if (arr[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 5;

        int result = bs.binarySearch(arr, target);
        if (result != -1) {
            System.out.println("Target found at index: " + result);
        } else {
            System.out.println("Target not found in the array.");
        }
    }
}
