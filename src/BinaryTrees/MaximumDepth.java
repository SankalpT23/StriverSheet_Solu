package BinaryTrees;

public class MaximumDepth {
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

    public static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftH = maxDepth(root.left);
        int rightH = maxDepth(root.right);

        return 1 + Math.max(leftH, rightH);
    }

    public static void main(String[] args) {

        /*
                 1
               /   \
              2     3
             / \
            4   5
           /
          8

        Max Depth = 4
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.left.left = new TreeNode(8);

        int depth = maxDepth(root);

        System.out.println("Maximum Depth = " + depth);
    }
}