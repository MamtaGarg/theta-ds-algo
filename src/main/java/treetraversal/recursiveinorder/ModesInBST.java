package treetraversal.recursiveinorder;

import java.util.ArrayList;
import java.util.List;

class ModesInBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    Integer prev = null;
    int count = 0;
    int maxCount = 0;
    List<Integer> modes = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inorder(root);
        return modes.stream().mapToInt(i -> i).toArray();
    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        // Process current node
        if (prev == null || root.val != prev) {
            count = 1;
        } else {
            count++;
        }

        if (count > maxCount) {
            maxCount = count;
            modes.clear();
            modes.add(root.val);
        } else if (count == maxCount) {
            modes.add(root.val);
        }

        prev = root.val;

        inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);

        ModesInBST sol = new ModesInBST();
        int[] result = sol.findMode(root);

        System.out.println("Modes are:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}