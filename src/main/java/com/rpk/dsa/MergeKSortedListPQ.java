package com.rpk.dsa;

/**
 * This class provides a method to merge k sorted linked lists into one sorted linked list.
 * The `mergeKLists` method uses a min-heap (priority queue) to efficiently merge the lists.
 * The method maintains a heap of the smallest elements from each list,
 *  ensuring that the next smallest element is always at the top of the heap.
 * The time complexity of this approach is O(N log k), where N is the total number
 * of nodes across all lists and k is the number of linked lists. 
 * This makes it efficient for merging multiple sorted lists.
 * 
 * MergeKSortedListPQ
 */

public class MergeKSortedListPQ {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        java.util.PriorityQueue<ListNode> minHeap = new java.util.PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            current.next = node;
            current = current.next;

            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        MergeKSortedListPQ merger = new MergeKSortedListPQ();

        // Create sample linked lists
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        ListNode[] lists = {list1, list2, list3};

        // Merge the k sorted linked lists
        ListNode mergedList = merger.mergeKLists(lists);

        // Print the merged linked list
        System.out.print("Merged Linked List: ");
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }

}