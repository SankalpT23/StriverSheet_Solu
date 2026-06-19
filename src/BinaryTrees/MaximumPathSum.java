package BinaryTrees;

public class MaximumPathSum {
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

    static int max = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public static int dfs(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int leftSum = Math.max(0, dfs(node.left));
        int rightSum = Math.max(0, dfs(node.right));

        max = Math.max(max, leftSum + rightSum + node.val);

        return node.val + Math.max(leftSum, rightSum);
    }

    public static void main(String[] args) {

        /*
                 -10
                 /  \
                9    20
                    /  \
                   15   7

            Maximum Path:
            15 -> 20 -> 7

            Sum = 42
        */

        TreeNode root = new TreeNode(-10);

        root.left = new TreeNode(9);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int result = maxPathSum(root);

        System.out.println("Maximum Path Sum = " + result);
    }
}