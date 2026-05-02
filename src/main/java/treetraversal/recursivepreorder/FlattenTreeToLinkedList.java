package treetraversal.recursivepreorder;

public class FlattenTreeToLinkedList {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode prev = null;

    private static void flattenBinaryTreeToLinkedList(TreeNode root) {
        if(root == null) return;

        flattenBinaryTreeToLinkedList(root.right);
        flattenBinaryTreeToLinkedList(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void printTree(TreeNode root) {
        if(root == null) return;
        System.out.print(root.val + ", ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(5);

        p.left.left = new TreeNode(3);
        p.left.right = new TreeNode(4);

        p.right.right = new TreeNode(6);

        printTree(p);
        flattenBinaryTreeToLinkedList(p);
        System.out.println();
        printTree(p);
    }
}
