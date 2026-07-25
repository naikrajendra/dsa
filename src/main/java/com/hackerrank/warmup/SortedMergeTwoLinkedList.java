package com.hackerrank.warmup;

import java.util.Scanner;

public class SortedMergeTwoLinkedList {

    // Simple Node structure to represent each element in the list
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Helper class to manage the list creation
    static class CustomLinkedList {
        Node head;
        Node tail;

        void insertNode(int data) {
            Node newNode = new Node(data);
            if (this.head == null) {
                this.head = newNode;
            } else {
                this.tail.next = newNode;
            }
            this.tail = newNode;
        }
    }

    /*
     * Merges two sorted linked lists and returns the head of the new sorted list.
     */
    public static Node sortedMergedLinkedList(Node headA, Node headB) {
        // Create a dummy node to seamlessly anchor the new list
        Node dummyNode = new Node(-1);
        Node current = dummyNode;

        // Traverse both lists until one runs out of items
        while (headA != null && headB != null) {
            if (headA.data <= headB.data) {
                current.next = headA;
                headA = headA.next; // Advance the first pointer
            } else {
                current.next = headB;
                headB = headB.next; // Advance the second pointer
            }
            current = current.next; // Move the merged tracker forward
        }

        // Attach any remaining nodes from whichever list isn't empty
        if (headA != null) {
            current.next = headA;
        } else {
            current.next = headB;
        }

        // Return the actual head of the sorted list (skipping the dummy)
        return dummyNode.next;
    }

    // Helper method to print the final list to the console
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read total number of test cases
        int tests = scanner.nextInt();

        for (int t = 0; t < tests; t++) {
            // Build the first linked list
            CustomLinkedList list1 = new CustomLinkedList();
            int count1 = scanner.nextInt();
            for (int i = 0; i < count1; i++) {
                list1.insertNode(scanner.nextInt());
            }

            // Build the second linked list
            CustomLinkedList list2 = new CustomLinkedList();
            int count2 = scanner.nextInt();
            for (int i = 0; i < count2; i++) {
                list2.insertNode(scanner.nextInt());
            }

            // Call the renamed merging function
            Node mergedHead = sortedMergedLinkedList(list1.head, list2.head);

            // Print the final result
            printList(mergedHead);
        }

        scanner.close();
    }
}
