package BinaryTrees.Hard;

import java.util.ArrayList;

public class RootTOLeaf {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private boolean getPath(TreeNode root, ArrayList<Integer> path, int target) {

        if (root == null) {
            return false;
        }

        path.add(root.val);

        if (root.val == target) {
            return true;
        }

        if (getPath(root.left, path, target) ||
                getPath(root.right, path, target)) {
            return true;
        }

        path.remove(path.size() - 1);

        return false;
    }

    public ArrayList<Integer> solve(TreeNode root, int target) {
        ArrayList<Integer> path = new ArrayList<>();

        if (root == null) {
            return path;
        }

        getPath(root, path, target);

        return path;
    }

    // Driver Code
    public static void main(String[] args) {

        RootTOLeaf solution = new RootTOLeaf();

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

        int target = 5;

        ArrayList<Integer> path = solution.solve(root, target);

        System.out.println("Root to Node Path:");
        System.out.println(path);
    }
}