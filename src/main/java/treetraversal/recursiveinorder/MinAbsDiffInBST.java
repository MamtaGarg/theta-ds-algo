package treetraversal.recursiveinorder;

public class MinAbsDiffInBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int minDiff = Integer.MAX_VALUE;
    static TreeNode prev = null;

    public static void findMinAbsDiff(TreeNode root) {
        findDiff(root);
    }

    private static void findDiff(TreeNode root) {
        if(root == null) return;


        findDiff(root.left);
        if(prev != null)
             minDiff = Math.min(minDiff, Math.abs(prev.val - root.val));
        prev = root;
        findDiff(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        findMinAbsDiff(root);
        System.out.println(minDiff);
    }
}
