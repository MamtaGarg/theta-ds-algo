package treetraversal.recursivepreorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreePaths {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<String> result = new ArrayList<>();
        findUniqueBinaryPaths(root, "", result);
        return result;
    }

    private static void findUniqueBinaryPaths(TreeNode root, String path, List<String> result) {
        if(root == null) return;

        if(path.isEmpty()) {
            path = String.valueOf(root.val);
        } else {
            path = path + "->" + root.val;
        }

        if(root.left == null && root.right == null) {
            result.add(path);
            return;
        }

        findUniqueBinaryPaths(root.left, path, result);
        findUniqueBinaryPaths(root.right, path, result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(6);

        List<String> treePaths = binaryTreePaths(root);

        treePaths.forEach(x -> System.out.println(x));
    }
}
