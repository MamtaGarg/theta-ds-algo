package treetraversal.recursiveinorder;

public class ValidateBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean validateBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean validate(TreeNode root, Long minValue, Long maxValue) {
        if(root == null) return true;

        if(root.val <= minValue || root.val >= maxValue) return false;

        return validate(root.left, minValue, (long) root.val) && validate(root.right, (long) root.val, maxValue);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        //root.left.right = new TreeNode(2);

        System.out.println(validateBST(root));
    }
}
