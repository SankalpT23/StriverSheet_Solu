package BinarySearchTrees;

public class SearchInBST {

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

    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.val == val) {
                return curr;
            } else if (val > curr.val) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        SearchInBST solution = new SearchInBST();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int target = 2;

        TreeNode result = solution.searchBST(root, target);

        if (result != null) {
            System.out.println("Node found: " + result.val);
        } else {
            System.out.println("Node not found.");
        }
    }
}