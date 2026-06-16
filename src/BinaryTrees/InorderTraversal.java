package BinaryTrees;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

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

    public static void main(String[] args) {

        /*
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        InorderTraversal traversal = new InorderTraversal();

        List<Integer> result = traversal.inorderTraversal(root);

        System.out.println(result);
    }

    private List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();

        TreeNode node = root;

        while (true) {
            if (node != null) {
                s.push(node);
                node = node.left;
            } else {
                if (s.isEmpty()) {
                    break;
                }

                node = s.pop();
                list.add(node.val);

                node = node.right;
            }
        }

        return list;
    }
}