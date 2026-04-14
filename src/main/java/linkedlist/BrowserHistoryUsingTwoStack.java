package linkedlist;

import java.util.Stack;

/**
 * Problem: Implement browser history navigation (visit, back, forward) using two stacks.
  Visiting a new URL clears all forward history.

 * Example:
    visit("a.com"), visit("b.com"), back(1) → "a.com", forward(1) → "b.com"

 * Logic:
    1. Maintain a backStack (pages behind current), a forwardStack (pages ahead), and current URL.
    2. visit(): Push current onto backStack, set current to the new URL, clear forwardStack.
    3. back(): Push current onto forwardStack, pop from backStack into current. Repeat up to steps times.
    4. forward(): Push current onto backStack, pop from forwardStack into current. Repeat up to steps times.

 * Time Complexity:  O(1) for visit, O(steps) for back/forward.
 * Space Complexity: O(n) — total URLs stored across both stacks plus current.
 */
class BrowserHistoryUsingTwoStack {

    private Stack<String> backStack;
    private Stack<String> forwardStack;
    private String current;

    public BrowserHistoryUsingTwoStack(String homepage) {
        backStack = new Stack<>();
        forwardStack = new Stack<>();
        // Start at the homepage
        current = homepage;
    }

    public void visit(String url) {
        // Save current page to back history
        backStack.push(current);
        // Navigate to the new URL
        current = url;
        // Clear forward history — new visit invalidates old forward pages
        forwardStack.clear();
    }

    public String back(int steps) {
        // Move current to forward stack and pop from back stack
        while (steps-- > 0 && !backStack.isEmpty()) {
            forwardStack.push(current);
            current = backStack.pop();
        }
        return current;
    }

    public String forward(int steps) {
        // Move current to back stack and pop from forward stack
        while (steps-- > 0 && !forwardStack.isEmpty()) {
            backStack.push(current);
            current = forwardStack.pop();
        }
        return current;
    }
}