package com.rpk.dsa;

/**
 * This class provides a method to invert a binary tree.
 * Inverting a binary tree means swapping the left and right children of all nodes in the tree.
 * The `invertTree` method recursively swaps the left and right subtrees of each node.  
 * The time complexity of this approach is O(n), where n is the number of nodes in the binary tree, as each node is visited exactly once.
 * The space complexity is O(h), where h is the height of the tree, due to the recursive call stack.    
 * 
 * InvertBinaryTree
 */

public class InvertBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Swap the left and right subtrees
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert the left and right subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void main(String[] args) {
        InvertBinaryTree tree = new InvertBinaryTree();

        // Create a sample binary tree
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.println("Original Binary Tree:");
        printInOrder(root); // Output: 1 2 3 4 6 7 9

        tree.invertTree(root);

        System.out.println("\nInverted Binary Tree:");
        printInOrder(root); // Output: 9 7 6 4 3 2 1
    }

    private static void printInOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.print(node.val + " ");
        printInOrder(node.right);
    }
}
