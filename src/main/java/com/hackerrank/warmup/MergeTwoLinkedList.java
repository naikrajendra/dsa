package com.hackerrank.warmup;

import java.io.*;
import java.util.*;

/**
 * Given pointers to the heads of two sorted linked lists, merge them into a
 * single, sorted linked list. Either head pointer may be null meaning that the
 * corresponding list is empty.
 * 
 * Example
 * refers to
 * refers to
 * 
 * The new list is
 * 
 * Function Description
 * 
 * Complete the mergeLists function in the editor below.
 * 
 * mergeLists has the following parameters:
 * 
 * SinglyLinkedListNode pointer headA: a reference to the head of a list
 * SinglyLinkedListNode pointer headB: a reference to the head of a list
 * Returns
 * 
 * SinglyLinkedListNode pointer: a reference to the head of the merged list
 * Input Format
 * 
 * The first line contains an integer , the number of test cases.
 * 
 * The format for each test case is as follows:
 * 
 * The first line contains an integer , the length of the first linked list.
 * The next lines contain an integer each, the elements of the linked list.
 * The next line contains an integer , the length of the second linked list.
 * The next lines contain an integer each, the elements of the second linked
 * list.
 * 
 * Constraints
 * 
 * , where is the element of the list.
 * Sample Input
 * 
 * 1
 * 3
 * 1
 * 2
 * 3
 * 2
 * 3
 * 4
 * Sample Output
 * 
 * 1 2 3 3 4
 * Explanation
 * 
 * The first linked list is:
 * 
 * The second linked list is:
 * 
 * Hence, the merged linked list is:
 */

public class MergeTwoLinkedList {

    // HackerRank's standard SinglyLinkedListNode architecture
    static class Node {
        int data;
        Node next;

        Node(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class CustomLinkedList {
        Node head;
        Node tail;

        void insertNode(int nodeData) {
            Node node = new Node(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    /*
     * Complete the 'mergeLists' function below.
     *
     * The function is expected to return a SinglyLinkedListNode.
     * The function accepts following parameters:
     * 1. SinglyLinkedListNode head1
     * 2. SinglyLinkedListNode head2
     */
    static Node mergeLists(Node head1, Node head2) {
        // Create a dummy node to seamlessly anchor the new list
        Node returnNode = new Node(-1);
        Node current = returnNode;

        // Traverse both lists until one of them runs out of items
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                current.next = head1;
                head1 = head1.next; // Advance the first pointer
            } else {
                current.next = head2;
                head2 = head2.next; // Advance the second pointer
            }
            current = current.next; // Move the merged tracker forward
        }

        // Attach any remaining nodes from either list
        if (head1 != null) {
            current.next = head1;
        } else {
            current.next = head2;
        }

        // Return the actual head of the sorted list (skipping the dummy)
        return returnNode.next;
    }

    // Helper method to print the final merged list
    public static void printCustomLinkedList(Node node, String sep) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
            if (node != null) {
                System.out.print(sep);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the total number of test cases
        int tests = scanner.nextInt();

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            // Build the first linked list
            CustomLinkedList llist1 = new CustomLinkedList();
            int llist1Count = scanner.nextInt();
            for (int i = 0; i < llist1Count; i++) {
                llist1.insertNode(scanner.nextInt());
            }

            // Build the second linked list
            CustomLinkedList llist2 = new CustomLinkedList();
            int llist2Count = scanner.nextInt();
            for (int i = 0; i < llist2Count; i++) {
                llist2.insertNode(scanner.nextInt());
            }

            // Merge the lists and output the result
            Node llist3 = mergeLists(llist1.head, llist2.head);
            printCustomLinkedList(llist3, " ");
            System.out.println();
        }

        scanner.close();
    }

}
