package treetraversal.recursiveinorder;

public class KthSmallestInBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int count = 0;
    static int result = -1;

    public static void findKthSmallest(TreeNode root, int k) {
        findKthSmallestElement(root, k);
    }

    private static void findKthSmallestElement(TreeNode root, int k) {
        if(root == null) return;

        findKthSmallestElement(root.left, k);

        count++;
        if(count == k) {
            result = root.val;
            return;
        }

        findKthSmallestElement(root.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        root.left.right = new TreeNode(2);
        findKthSmallest(root, 1);
        System.out.println(result);
    }
}
