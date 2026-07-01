package BinaryTrees.Hard;

public class LCA {

    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Function to find Lowest Common Ancestor
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null){
            return root;
        }else if(left != null){
            return left;
        }else{
            return right;
        }
    }

    public static void main(String[] args) {

        /*
                 3
               /   \
              5     1
             / \   / \
            6   2 0   8
               / \
              7   4

         LCA(5,1) = 3
         LCA(5,4) = 5
        */

        // Creating the tree
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // Selecting nodes
        TreeNode p = root.left;                  // Node 5
        TreeNode q = root.left.right.right;      // Node 4

        TreeNode lca = lowestCommonAncestor(root, p, q);

        if (lca != null) {
            System.out.println("Lowest Common Ancestor: " + lca.val);
        } else {
            System.out.println("LCA not found.");
        }
    }
}