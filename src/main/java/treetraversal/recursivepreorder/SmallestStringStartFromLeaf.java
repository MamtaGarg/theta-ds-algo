package treetraversal.recursivepreorder;

public class SmallestStringStartFromLeaf {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static String result = null;
    public static String smallestFromLeaf(TreeNode root) {
        smallestString(root, "");
        return result;
    }

    public static void smallestString(TreeNode root, String path) {
        if(root == null) return;

        path = (char) ('a' + root.val) + path;
        if(root.left == null && root.right == null) {
            if(result == null || path.compareTo(result) < 0) {
                result = path;
            }
        }
        smallestString(root.left, path);
        smallestString(root.right, path);
    }

    public static void printTree(TreeNode root) {
        if(root == null) return;
        System.out.print(root.val + ", ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(0);
        p.left = new TreeNode(1);
        p.right = new TreeNode(2);

        p.left.left = new TreeNode(3);
        p.left.right = new TreeNode(4);

        p.right.left = new TreeNode(3);
        p.right.right = new TreeNode(4);

        printTree(p);
        System.out.println(smallestFromLeaf(p));
    }
}
