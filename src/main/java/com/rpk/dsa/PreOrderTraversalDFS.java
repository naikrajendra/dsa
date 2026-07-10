package com.rpk.dsa;

/**
 * This class provides a method to perform pre-order traversal of a binary tree 
 * using depth-first search (DFS).
 * Preorder traversal DFS = root --> left --> right
 * The `preOrderTraversalDFS` method processes the current node, then recursively 
 * visits the left and right subtrees.
 * The time complexity of this approach is O(n), where n is the number of nodes 
 * in the binary tree, as each node is visited exactly once.
 * The space complexity is O(h), where h is the height of the tree, due to the 
 * recursive call stack.    
 * 
 * PreOrderTraversalDFS
 */

public class PreOrderTraversalDFS {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void preOrderTraversalDFS(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrderTraversalDFS(root.left);
        preOrderTraversalDFS(root.right);
    }

    public static void main(String[] args) {
        PreOrderTraversalDFS traversal = new PreOrderTraversalDFS();

        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.print("Pre-order Traversal: ");
        traversal.preOrderTraversalDFS(root); // Output: 1 2 4 5 3
    }   

}
