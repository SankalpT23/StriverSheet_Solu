package BinaryTrees.Medium;

import java.util.*;


public class VerticalOrderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Tuple {
        TreeNode node;
        int row;
        int col;

        Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0));

        while (!queue.isEmpty()) {

            Tuple tuple = queue.poll();

            TreeNode node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;

            map.putIfAbsent(x, new TreeMap<>());
            map.get(x).putIfAbsent(y, new PriorityQueue<>());

            map.get(x).get(y).offer(node.val);

            if (node.left != null) {
                queue.offer(new Tuple(node.left, x - 1, y + 1));
            }

            if (node.right != null) {
                queue.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }

        List<List<Integer>> answer = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> levels : map.values()) {

            List<Integer> list = new ArrayList<>();

            for (PriorityQueue<Integer> pq : levels.values()) {
                while (!pq.isEmpty()) {
                    list.add(pq.poll());
                }
            }

            answer.add(list);
        }

        return answer;
    }

    public static void main(String[] args) {

        /*
                    3
                  /   \
                 9     20
                      /  \
                     15   7
        */

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = verticalTraversal(root);

        System.out.println("Vertical Traversal:");

        for (List<Integer> column : result) {
            System.out.println(column);
        }
    }
}