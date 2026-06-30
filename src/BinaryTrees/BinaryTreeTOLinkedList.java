package BinaryTrees;

import java.util.Stack;

public class BinaryTreeTOLinkedList {

    // TreeNode class
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Solution class
    static class Solution {

        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }

            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode current = stack.pop();

                if (current.right != null) {
                    stack.push(current.right);
                }

                if (current.left != null) {
                    stack.push(current.left);
                }

                if (!stack.isEmpty()) {
                    current.right = stack.peek();
                }

                current.left = null;
            }
        }
    }

    // Print flattened tree
    static void printList(TreeNode root) {
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(6);

        Solution solution = new Solution();
        solution.flatten(root);

        System.out.println("Flattened Tree:");
        printList(root);
    }
}