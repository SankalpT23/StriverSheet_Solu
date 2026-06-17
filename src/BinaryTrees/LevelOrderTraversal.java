package BinaryTrees;

import java.util.*;


public class LevelOrderTraversal {
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

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root == null) {
            return list;
        }

        q.offer(root);

        while (!q.isEmpty()) {

            int levelNum = q.size();
            List<Integer> sublist = new LinkedList<>();

            for (int i = 0; i < levelNum; i++) {

                if (q.peek().left != null) {
                    q.offer(q.peek().left);
                }

                if (q.peek().right != null) {
                    q.offer(q.peek().right);
                }

                sublist.add(q.poll().val);
            }

            list.add(sublist);
        }

        return list;
    }

    public static void main(String[] args) {

        /*
                 1
               /   \
              2     3
             / \   / \
            4  5  6   7
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = levelOrder(root);

        System.out.println(result);
    }
}