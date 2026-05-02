package treetraversal.recursivepreorder;

public class BinarySameTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        return isBinarySameTree(p, q);
    }

    private static boolean isBinarySameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;

        if(p == null || q == null || p.val != q.val) return false;

        return isBinarySameTree(p.left, q.left) && isBinarySameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        //p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.right = new TreeNode(2);
       // q.right = new TreeNode(3);

        System.out.println(isSameTree(p, q));
    }
}
