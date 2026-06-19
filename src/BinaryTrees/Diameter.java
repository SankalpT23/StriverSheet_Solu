package BinaryTrees;

public class Diameter {
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

    static int max = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    public static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftH = maxDepth(root.left);
        int rightH = maxDepth(root.right);

        max = Math.max(max, leftH + rightH);

        return 1 + Math.max(leftH, rightH);
    }

    public static void main(String[] args) {

        /*
                  1
                 / \
                2   3
               / \
              4   5

            Diameter = 3

            Path:
            4 -> 2 -> 1 -> 3
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int diameter = diameterOfBinaryTree(root);

        System.out.println("Diameter = " + diameter);
    }
}