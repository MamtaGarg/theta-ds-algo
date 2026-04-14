# Tree (BFS / Level-Order Traversal) Guide

---

## Tree — Level-Order Traversal Pattern

> **Core idea:** Use a queue (BFS) to process nodes level by level. At each level, drain the queue by its current size, process all nodes, and enqueue their children for the next level.

### Problems

| # | Problem Statement | Time | Space | Logic |
|---|---|---|---|---|
| 1 | [Largest Value In Each Row](https://github.com/MamtaGarg/theta-ds-algo/tree/main/src/main/java/tree/LargestValueInEachRow.java) | O(n) | O(n) | BFS level-order traversal; track the max value per level and add it to the result list. |
| 2 | [Reverse Level Order Traversal](https://github.com/MamtaGarg/theta-ds-algo/tree/main/src/main/java/tree/ReverseLevelOrderTraversal.java) | O(n) | O(n) | BFS level-order traversal; insert each level's list at the beginning of the result (addFirst) to get bottom-up ordering without a final reverse. |
| 3 | [Zigzag Traversal](https://github.com/MamtaGarg/theta-ds-algo/tree/main/src/main/java/tree/ZigzagTraversal.java) | O(n) | O(n) | BFS with a direction flag; use addLast for left-to-right levels and addFirst for right-to-left levels. Flip direction after each level. |

### When to Use Level-Order Traversal
- Need to process a tree level by level (row by row)
- Finding min/max/average per level
- Reversing or zigzagging the traversal order
- Any problem requiring BFS on a tree structure
