package treetraversal.lowestcommonanscestor;

import treetraversal.recursiveinorder.ValidateBST;

public class LowestCommonAncestor {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == root || q == root) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) return root;

        return left != null ? left : right;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // Example 1: p = 5, q = 1 → LCA = 3
        TreeNode p = root.left;   // 5
        TreeNode q = root.right;  // 1

        TreeNode lca = lowestCommonAncestor(root, p, q);
        System.out.println("LCA of 5 and 1: " + lca.val);

        // Example 2: p = 5, q = 4 → LCA = 5
        TreeNode p2 = root.left;                  // 5
        TreeNode q2 = root.left.right.right;      // 4

        TreeNode lca2 = lowestCommonAncestor(root, p2, q2);
        System.out.println("LCA of 5 and 4: " + lca2.val);
    }
}
