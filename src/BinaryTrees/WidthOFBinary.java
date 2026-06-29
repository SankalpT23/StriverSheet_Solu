package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class WidthOFBinary {

    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Pair class to store node and its index
    static class Pair {
        TreeNode node;
        int num;

        Pair(TreeNode node, int num) {
            this.node = node;
            this.num = num;
        }
    }

    // Function to calculate maximum width of binary tree
    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<Pair> q = new LinkedList<>();
        int ans = 0;

        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            int min = q.peek().num;

            int left = 0;
            int right = 0;

            for (int i = 0; i < size; i++) {
                Pair current = q.poll();

                int currId = current.num - min;
                TreeNode node = current.node;

                if (i == 0) {
                    left = currId;
                }

                if (i == size - 1) {
                    right = currId;
                }

                if (node.left != null) {
                    q.offer(new Pair(node.left, currId * 2 + 1));
                }

                if (node.right != null) {
                    q.offer(new Pair(node.right, currId * 2 + 2));
                }
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }

    public static void main(String[] args) {

        /*
                  1
                /   \
               3     2
              / \     \
             5   3     9

            Maximum Width = 4
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(3);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);

        root.right.right = new TreeNode(9);

        int width = widthOfBinaryTree(root);

        System.out.println("Maximum Width of Binary Tree: " + width);
    }
}