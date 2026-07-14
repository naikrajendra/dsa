package com.rpk.dsa;

/**
 * This class provides a method to determine if there exists a root-to-leaf path in a binary tree such that the sum of the node values along the path equals a given target sum.
 * The `hasPathSum` method recursively checks each path from the root to the leaves, subtracting the value of the current node from the target sum until it reaches a leaf node.
 * The time complexity of this approach is O(n), where n is the number of nodes in the binary tree, as each node is visited exactly once.       
 * The space complexity is O(h), where h is the height of the tree, due to the recursive call stack.    
 * 
 * PathSum
 */

public class PathSum {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        // Check if we have reached a leaf node
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // Recursively check the left and right subtrees with the updated target sum
        int remainingSum = targetSum - root.val;
        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
    }

    public static void main(String[] args) {
        PathSum tree = new PathSum();

        // Create a sample binary tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;
        boolean result = tree.hasPathSum(root, targetSum);
        System.out.println("Has path sum of " + targetSum + ": " + result); // Output: true
    }

}
