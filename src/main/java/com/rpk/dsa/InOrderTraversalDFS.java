package com.rpk.dsa;

/**
 * This class provides a method to perform in-order traversal of a binary tree 
 * using depth-first search (DFS).
 * Inorder traversal DFS = left --> root --> right
 * The `inOrderTraversalDFS` method recursively visits the left subtree, 
 * processes the current node, and then visits the right subtree.
 * The time complexity of this approach is O(n), where n is the number of nodes in the binary tree, as each node is visited exactly once.
 * The space complexity is O(h), where h is the height of the tree, due to the recursive call stack.    
 * 
 * InOrderTraversalDFS
 */

public class InOrderTraversalDFS {

        static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void inOrderTraversalDFS(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversalDFS(root.left);
        System.out.print(root.val + " ");
        inOrderTraversalDFS(root.right);
    }

    public static void main(String[] args) {
        InOrderTraversalDFS traversal = new InOrderTraversalDFS();

        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.print("In-order Traversal: ");
        traversal.inOrderTraversalDFS(root); // Output: 1 3 2
    }



}
