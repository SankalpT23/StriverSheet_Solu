package BinaryTrees.Medium;

import java.util.*;


public class RightSideView {
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

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list, 0);
        return list;
    }

    public static void traversal(TreeNode node, List<Integer> list, int level) {

        if (node == null) {
            return;
        }

        if (level == list.size()) {
            list.add(node.val);
        }

        traversal(node.right, list, level + 1);
        traversal(node.left, list, level + 1);
    }

    public static void main(String[] args) {

        /*
                    1
                  /   \
                 2     3
                  \     \
                   5     4

            Right Side View:
            [1, 3, 4]
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        List<Integer> result = rightSideView(root);

        System.out.println(result);
    }
}