package com.rpk.dsa;

/**
 * This class provides a method to perform post-order traversal of a binary tree 
 * using depth-first search (DFS).
 * Postorder traversal DFS = left --> right --> root
 * The `postOrderTraversalDFS` method recursively visits the left and right subtrees, and then processes the current node.
 * The time complexity of this approach is O(n), where n is the number of nodes in the binary tree, as each node is visited exactly once.
 * The space complexity is O(h), where h is the height of the tree, due to the recursive call stack.    
 * 
 * PostOrderTraversalDFS
 */

public class PostOrderTraversalDFS {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void postOrderTraversalDFS(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversalDFS(root.left);
        postOrderTraversalDFS(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {
        PostOrderTraversalDFS traversal = new PostOrderTraversalDFS();

        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.print("Post-order Traversal: ");
        traversal.postOrderTraversalDFS(root); // Output: 3 2 1
    }

}
