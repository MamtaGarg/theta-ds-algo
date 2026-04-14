package linkedlist;

/**
 * Problem: Implement browser history navigation (visit, back, forward) using a
  doubly linked list. Visiting a new URL clears all forward history.

 * Example:
    visit("a.com"), visit("b.com"), back(1) → "a.com", forward(1) → "b.com"

 * Logic:
    1. Each node stores a URL and has prev/next pointers forming a doubly linked list.
    2. visit(): Create a new node, link it after current, and move current forward.
       Old forward nodes are automatically garbage collected (next is overwritten).
    3. back(): Move current backward up to the given number of steps (stop at head).
    4. forward(): Move current forward up to the given number of steps (stop at tail).

 * Time Complexity:  O(1) for visit, O(steps) for back/forward.
 * Space Complexity: O(n) — one node per visited URL in the active history chain.
 */
class BrowserHistoryDLL {

    private static class Node {
        String url;
        Node prev, next;

        Node(String url) {
            this.url = url;
        }
    }

    private Node current;

    public BrowserHistoryDLL(String homepage) {
        // Initialize with the homepage as the first node
        current = new Node(homepage);
    }

    public void visit(String url) {
        Node newNode = new Node(url);

        // Attach new node after current
        current.next = newNode;
        newNode.prev = current;

        // Move current pointer to the new page
        current = newNode;

        // Old forward nodes are automatically garbage collected
        // because we overwrote current.next
    }

    public String back(int steps) {
        // Move backward, stopping at the first page (head)
        while (steps > 0 && current.prev != null) {
            current = current.prev;
            steps--;
        }
        return current.url;
    }

    public String forward(int steps) {
        // Move forward, stopping at the last visited page (tail)
        while (steps > 0 && current.next != null) {
            current = current.next;
            steps--;
        }
        return current.url;
    }
}