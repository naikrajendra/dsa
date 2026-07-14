package com.rpk.dsa;

/**
 * This class provides a method to determine if a binary tree is height-balanced.
 * A binary tree is considered height-balanced if the heights of the two child subtrees of any node differ by no more than one.
 * The `isBalanced` method checks the balance of the tree by calculating the height of each subtree and ensuring that the difference in heights does not exceed one.
 * The time complexity of this approach is O(n), where n is the number of nodes in  the binary tree, as each node is visited exactly once.
 * The space complexity is O(h), where h is the height of the tree, due to the recursive call stack.    
 * 
 * BalancedBinaryTree
 */
public class BalancedBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private static int checkHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) {
            return -1; // Left subtree is not balanced
        }

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) {
            return -1; // Right subtree is not balanced
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Current node is not balanced
        }

        return Math.max(leftHeight, rightHeight) + 1; // Return the height of the current node
    }

    public static void main(String[] args) {
        BalancedBinaryTree tree = new BalancedBinaryTree();

        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        boolean result = tree.isBalanced(root);
        System.out.println("Is the binary tree balanced? " + result); // Output: true
    }

}
