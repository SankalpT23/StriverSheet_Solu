package BinaryTrees;

public class SameTree {

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

    public boolean isSameTree(TreeNode p, TreeNode q) {

        // Both nodes are null
        if (p == null && q == null) {
            return true;
        }

        // One node is null and the other is not
        if (p == null || q == null) {
            return false;
        }

        // Values differ
        if (p.val != q.val) {
            return false;
        }

        // Check left and right subtrees
        return isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {

        SameTree solution = new SameTree();

        /*
                Tree p:                 Tree q:

                    1                       1
                   / \                     / \
                  2   3                   2   3

                Expected Output: true
        */

        TreeNode p = new TreeNode(
                1,
                new TreeNode(2),
                new TreeNode(3)
        );

        TreeNode q = new TreeNode(
                1,
                new TreeNode(2),
                new TreeNode(3)
        );

        System.out.println(solution.isSameTree(p, q));
    }
}