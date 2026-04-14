package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * Problem: Given the root of a binary tree, return the largest value in each row
  (i.e., each level of the tree).

 * Example:
    Input:  root = [1, 2, 3, 4, 5, null, 6]
    Output: [1, 3, 6]

 * Logic:
    1. Perform a level-order traversal (BFS) using a queue.
    2. For each level, iterate through all nodes, tracking the maximum value.
    3. After processing all nodes in a level, add the maximum to the result list.
    4. Continue until the queue is empty (all levels visited).

 * Time Complexity:  O(n) — every node is visited exactly once.
 * Space Complexity: O(n) — the queue can hold up to n/2 nodes (widest level).
 */
public class LargestValueInEachRow {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> findLargestValueInEachRow(Node root) {
        List<Integer> list = new LinkedList<>();

        // Edge case: empty tree
        if(root == null) return list;

        // Initialize BFS queue with the root node
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int maxValue = Integer.MIN_VALUE;

            // Process all nodes at the current level
            for(int i = 0; i < size; i++) {
                Node node = queue.poll();
                int data = Objects.requireNonNull(node).val;
                // Track the maximum value for this level
                maxValue = Math.max(data, maxValue);

                // Enqueue children for the next level
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            // Add the level's maximum to the result
            list.add(maxValue);
        }

        return list;
    }

    public static List<Integer> findLargestValueInEachRowClean(Node root) {
        List<Integer> list = new LinkedList<>();
        if(root == null) return list;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int maxValue = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++) {
                Node node = queue.poll();
                int data = Objects.requireNonNull(node).val;
                maxValue = Math.max(data, maxValue);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            list.add(maxValue);
        }
        return list;
    }

    private static void printMaxValue(List<Integer> result) {
        result.forEach(x -> System.out.println(x + " "));

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = null;
        root.right.right = new Node(6);

        List<Integer> result = findLargestValueInEachRow(root);

        System.out.println("Max value of each row of tree : ");

        printMaxValue(result);
    }
}
