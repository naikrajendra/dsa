package com.rpk.dsa;

/**
 * This code implements a binary tree and provides methods for pre-order, in-order, and post-order traversal of the tree.
 * The `TreeNode` class represents a node in the binary tree, containing an integer value and references to its left and right children.
 * The traversal methods recursively visit nodes in the specified order and print their values to the console.
 * The main method demonstrates the creation of a binary tree and performs all three types of traversals, displaying the results.
 * 
 */


public class BinaryTreeOrderTraversal {

    //binary tree node
    static class TreeNode { 
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // Pre-order traversal (Root, Left, Right)
    public void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    // In-order traversal (Left, Root, Right)
    public void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }

    // Post-order traversal (Left, Right, Root)
    public void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val + " ");
    }

    //main method to test the traversal methods
    public static void main(String[] args) {    
        BinaryTreeOrderTraversal tree = new BinaryTreeOrderTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.print("Pre-order Traversal: ");
        tree.preOrderTraversal(root);
        System.out.println();

        System.out.print("In-order Traversal: ");
        tree.inOrderTraversal(root);
        System.out.println();

        System.out.print("Post-order Traversal: ");
        tree.postOrderTraversal(root);
        System.out.println();
    }


}
