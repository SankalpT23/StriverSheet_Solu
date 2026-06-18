package BinaryTrees;

public class SymmetricTree {
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

    public static boolean isSymmetric(TreeNode root) {
        return root == null || check(root.left, root.right);
    }

    private static boolean check(TreeNode n1, TreeNode n2) {

        if (n1 == null || n2 == null) {
            return n1 == n2;
        }

        if (n1.val != n2.val) {
            return false;
        }

        return check(n1.left, n2.right)
                && check(n1.right, n2.left);
    }

    public static void main(String[] args) {

        /*
                    1
                  /   \
                 2     2
                / \   / \
               3  4  4   3

            Symmetric = true
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        boolean result = isSymmetric(root);

        System.out.println("Is Symmetric: " + result);
    }
}
