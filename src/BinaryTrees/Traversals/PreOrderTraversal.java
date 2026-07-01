package BinaryTrees.Traversals;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
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

        PreOrderTraversal traversal = new PreOrderTraversal();

        List<Integer> result = traversal.preorderTraversal(root);

        System.out.println(result);
    }

    private List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        s.push(root);

        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            list.add(node.val);

            if (node.right != null) {
                s.push(node.right);
            }

            if (node.left != null) {
                s.push(node.left);
            }
        }

        return list;
    }
}
