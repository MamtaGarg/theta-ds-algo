package treetraversal.recursivepreorder;

public class InvertBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode invertBinaryTree(TreeNode root) {
        if(root == null) return root;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
        return root;
    }

    public static void printTree(TreeNode root) {
        if(root == null) return;
        System.out.print(root.val + ", ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(4);
        p.left = new TreeNode(2);
        p.right = new TreeNode(7);

        p.left.left = new TreeNode(1);
        p.left.right = new TreeNode(3);
        p.right.left = new TreeNode(6);
        p.right.right = new TreeNode(9);

        printTree(p);
        invertBinaryTree(p);
        System.out.println();
        printTree(p);
    }
}
