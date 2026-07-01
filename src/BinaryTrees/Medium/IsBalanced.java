package BinaryTrees.Medium;


public class IsBalanced {
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

    public static boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }

    public static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftH = maxDepth(root.left);

        if (leftH == -1) {
            return -1;
        }

        int rightH = maxDepth(root.right);

        if (rightH == -1) {
            return -1;
        }

        if (Math.abs(leftH - rightH) > 1) {
            return -1;
        }

        return 1 + Math.max(leftH, rightH);
    }

    public static void main(String[] args) {

        /*
                  1
                 /
                2
               /
              3
             /
            4

            Not Balanced
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

        boolean result = isBalanced(root);

        System.out.println("Is Balanced: " + result);
    }
}