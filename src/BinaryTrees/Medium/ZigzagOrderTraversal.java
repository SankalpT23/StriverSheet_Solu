package BinaryTrees.Medium;

import java.util.*;

public class ZigzagOrderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> finalList = levelOrder(root);

        for (int i = 0; i < finalList.size(); i++) {
            if (i % 2 != 0) {
                Collections.reverse(finalList.get(i));
            }
        }

        return finalList;
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

        ZigzagOrderTraversal solution = new ZigzagOrderTraversal();

        /*
                    3
                   / \
                  9  20
                    /  \
                   15   7

            Level Order:
            [[3], [9, 20], [15, 7]]

            Zigzag Level Order:
            [[3], [20, 9], [15, 7]]

            Expected Output:
            [[3], [20, 9], [15, 7]]
        */

        TreeNode root = new TreeNode(
                3,
                new TreeNode(9),
                new TreeNode(
                        20,
                        new TreeNode(15),
                        new TreeNode(7)
                )
        );

        System.out.println(solution.zigzagLevelOrder(root));
    }
}
