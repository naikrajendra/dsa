package com.rpk.dsa;
/**
 * This code implements the Floyd's Tortoise and Hare algorithm 
 * (also known as the Slow and Fast Pointer technique) 
 * to detect if a linked list has a cycle. 
 * The `hasCycle` method takes the head of the linked list as input 
 * and returns `true` if a cycle is detected, otherwise it returns `false`. 
 * The algorithm uses two pointers, where one moves at normal speed (slow) 
 * and the other moves at double speed (fast). If there is a cycle, 
 * the fast pointer will eventually meet the slow pointer. If there is no cycle,
 *  the fast pointer will reach the end of the list.
 */

public class SlowFastPointer {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    /**
     * Detects if a linked list has a cycle.
     *
     * @param head the head of the linked list
     * @return true if a cycle is detected, false otherwise
     */
    public boolean hasCycle(Node head) {
        if (head == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer by 1
            fast = fast.next.next; // Move fast pointer by 2

            if (slow == fast) { // A cycle is detected
                return true;
            }
        }

        return false; // No cycle found
    }

    public static void main(String[] args) {
        SlowFastPointer list = new SlowFastPointer();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head; // Creates a cycle

        System.out.println(list.hasCycle(head)); // Output: true
    }


}
