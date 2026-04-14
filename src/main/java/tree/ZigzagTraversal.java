package tree;

import java.util.*;

/**
 * Problem: Given the root of a binary tree, return the zigzag level order traversal
  (i.e., left-to-right on level 0, right-to-left on level 1, alternating).

 * Example:
    Input:  root = [1, 2, 3, 4, 5, 6, 7]
    Output: [[1], [3, 2], [4, 5, 6, 7]]

 * Logic:
    1. Perform a level-order traversal (BFS) using a queue.
    2. Maintain a boolean flag leftToRight to track the current direction.
    3. For each level, use a LinkedList: addLast for left-to-right, addFirst for right-to-left.
    4. Flip the direction after each level.

 * Time Complexity:  O(n) — every node is visited exactly once.
 * Space Complexity: O(n) — the queue can hold up to n/2 nodes (widest level).
 */
public class ZigzagTraversal {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        // Edge case: empty tree
        if (root == null) return result;

        // Initialize BFS queue with the root node
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Direction flag: true = left-to-right, false = right-to-left
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            // LinkedList allows efficient insertion at both ends
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (leftToRight) {
                    // Normal order — append to the end
                    level.addLast(node.val);
                } else {
                    // Reverse order — insert at the front
                    level.addFirst(node.val);
                }

                // Enqueue children for the next level
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(level);
            // Flip direction for the next level
            leftToRight = !leftToRight;
        }

        return result;
    }

    public static List<List<Integer>> zigzagLevelOrderClean(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) level.addLast(node.val);
                else level.addFirst(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(level);
            leftToRight = !leftToRight;
        }
        return result;
    }

    // Helper method to print result
    public static void printResult(List<List<Integer>> result) {
        for (List<Integer> level : result) {
            for (int val : level) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        /*
                1
              /   \
             2     3
            / \   / \
           4   5 6   7
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = zigzagLevelOrder(root);

        System.out.println("Zigzag Traversal:");
        printResult(result);
    }
}