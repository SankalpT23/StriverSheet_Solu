package BinaryTrees;

import java.util.Stack;

public class CountTreeNode {

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

        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int count = 0;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode current = stack.pop();
                count++;

                if (current.left != null) {
                    stack.push(current.left);
                }

                if (current.right != null) {
                    stack.push(current.right);
                }
            }

            return count;
        }
    }

    public static void main(String[] args) {

        /*
                1
               / \
              2   3
             / \   \
            4   5   6

        Total Nodes = 6
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);

        Solution solution = new Solution();

        int totalNodes = solution.countNodes(root);

        System.out.println("Total Number of Nodes: " + totalNodes);
    }
}