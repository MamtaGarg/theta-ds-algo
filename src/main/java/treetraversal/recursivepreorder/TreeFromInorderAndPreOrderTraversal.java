package treetraversal.recursivepreorder;

import java.util.HashMap;
import java.util.Map;

public class TreeFromInorderAndPreOrderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    static Map<Integer, Integer> map = new HashMap<>();
    static int index = 0;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length != inorder.length) return null;

        for(int i = 0; i < preorder.length; i++) {
            map.put(inorder[i], i);
        }
       return attachNodeWithParent(preorder, 0, preorder.length - 1);
    }


    private static TreeNode attachNodeWithParent(int[] preorder, int start, int end) {
        if(start > end) return null;

        TreeNode node = new TreeNode(preorder[index]);

        int inorderIndex = map.get(preorder[index]);
        index++;

        node.left = attachNodeWithParent(preorder, start, inorderIndex - 1);
        node.right = attachNodeWithParent(preorder, inorderIndex + 1, end);

        return node;
    }

    public static void printTree(TreeNode root) {
        if(root == null) return;
        System.out.print(root.val + ", ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};

        TreeNode root = buildTree(preorder, inorder);
        printTree(root);
    }
}
