package com.rpk.dsa;

/**
 * This class provides a method to calculate the sum of all left leaves in a binary tree.
 * A left leaf is defined as a leaf node that is the left child of its parent.  
 * The `sumOfLeftLeaves` method recursively traverses the binary tree and accumulates the values of left leaves.
 * The time complexity of this approach is O(n), where n is the number of nodes in the binary tree, as each node is visited exactly once.
 * The space complexity is O(h), where h is the height of the tree, due to the recursive call stack.    
 * 
 * SumOfLeftLeaves
 */

public class SumOfLeftLeaves {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;

        // Check if the left child is a leaf node
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }

        // Recursively calculate the sum for left and right subtrees
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);

        return sum;
    }

    public static void main(String[] args) {
        SumOfLeftLeaves tree = new SumOfLeftLeaves();

        // Create a sample binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int result = tree.sumOfLeftLeaves(root);
        System.out.println("Sum of left leaves: " + result); // Output: 24 (9 + 15)
    }

}
