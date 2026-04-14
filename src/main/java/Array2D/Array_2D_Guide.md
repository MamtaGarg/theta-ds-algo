# Array 2D Guide

---

## 2D Array — Search & Traversal Patterns

> **Core idea:** Treat a 2D matrix as a virtual structure (flattened 1D array for binary search, or layered boundaries for spiral traversal) to achieve efficient search or ordered access.

### Problems

| # | Problem Statement | Time | Space | Logic |
|---|---|---|---|---|
| 1 | [Binary Search In Matrix](https://github.com/MamtaGarg/theta-ds-algo/tree/main/src/main/java/Array2D/BinarySearchInMatrix.java) | O(log(m·n)) | O(1) | Treat the row-sorted matrix as a virtual 1D sorted array. Apply binary search on indices 0 to m·n−1, converting mid to 2D coordinates: row = mid / n, col = mid % n. |
| 2 | [Spiral Matrix](https://github.com/MamtaGarg/theta-ds-algo/tree/main/src/main/java/Array2D/SpiralMatrix.java) | O(m·n) | O(1) | Maintain four boundaries (top, bottom, left, right). Traverse right → down → left → up, shrinking boundaries inward after each full pass. |

### When to Use These Patterns
- Matrix is sorted row-wise and column-wise → binary search with index mapping
- Need to traverse all elements in a specific order (spiral, diagonal, etc.) → boundary tracking
- Want O(1) extra space for search or traversal
