package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem: Given the root of a binary tree, return the bottom-up level order traversal
  (i.e., from leaves to root, left to right level by level).

 * Example:
    Input:  root = [1, 2, 3, 4, 5, 6, 7]
    Output: [[4, 5, 6, 7], [2, 3], [1]]

 * Logic:
    1. Perform a standard level-order traversal (BFS) using a queue.
    2. Collect nodes level by level into a list.
    3. Insert each level's list at the beginning of the result (addFirst) instead of the end.
    4. This naturally produces the bottom-up ordering without a final reverse.

 * Time Complexity:  O(n) — every node is visited exactly once.
 * Space Complexity: O(n) — the queue can hold up to n/2 nodes (widest level).
 */
public class ReverseLevelOrderTraversal {

    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
        }
    }

    public static List<List<Integer>> findReverseLevelOrderTraversal(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        // Edge case: empty tree
        if(root == null) return result;

        // Initialize BFS queue with the root node
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            // Process all nodes at the current level
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                list.add(node.data);
                // Enqueue children for the next level
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            // Insert at the front to achieve bottom-up order
            result.addFirst(list);
        }
        return result;
    }

    public static List<List<Integer>> findReverseLevelOrderTraversalClean(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                list.add(node.data);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            result.addFirst(list);
        }
        return result;
    }

    private static void printReverseTree(List<List<Integer>> result) {
        System.out.print("[");
       for(List<Integer> list : result) {
           System.out.print("[");
           for(Integer value :  list) {
               System.out.print(value + ",");
           }
           System.out.print("] ");
       }
        System.out.print("]");

    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<List<Integer>> result = findReverseLevelOrderTraversal(root);

        System.out.println("Reverse traversal of tree : ");

        printReverseTree(result);
    }
}
