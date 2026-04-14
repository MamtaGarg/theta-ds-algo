# Linked List Guide

---

## Linked List — Browser History Pattern

> **Core idea:** Model browser navigation (visit, back, forward) using either a doubly linked list or two stacks. Visit clears forward history; back and forward traverse the history chain.

### Problems

| # | Problem Statement | Time | Space | Logic |
|---|---|---|---|---|
| 1 | [Browser History (Doubly Linked List)](https://github.com/MamtaGarg/theta-ds-algo/tree/main/src/main/java/linkedlist/BrowserHistoryDLL.java) | O(1) visit, O(steps) back/forward | O(n) | Each node stores a URL with prev/next pointers. Visit creates a new node after current (old forward nodes are garbage collected). Back/forward traverse the chain up to the given steps. |
| 2 | [Browser History (Two Stacks)](https://github.com/MamtaGarg/theta-ds-algo/tree/main/src/main/java/linkedlist/BrowserHistoryUsingTwoStack.java) | O(1) visit, O(steps) back/forward | O(n) | Back stack and forward stack shuttle the current URL between them. Visit pushes current to back stack and clears forward stack. Back/forward pop from one stack and push to the other. |

### When to Use These Patterns
- Need efficient insert + navigate (DLL gives O(1) visit, O(steps) traversal)
- Two-stack approach when you want simpler code without pointer management
- Any undo/redo or navigation history design problem
