# Merge Array Guide

---

## Merge Array — Two-Pointer Merge Pattern

> **Core idea:** Use pointers starting from the ends of both sorted arrays and fill the result from the back, placing the larger element first. This avoids shifting elements and achieves in-place merging.

### Problems

| # | Problem Statement | Time | Space | Logic |
|---|---|---|---|---|
| 1 | [Merge Sorted Arrays](https://github.com/MamtaGarg/theta-ds-algo/tree/main/src/main/java/MergeArray/MergeSortedArrays.java) | O(m + n) | O(1) | Three pointers from the ends: i (end of nums1 data), j (end of nums2), k (last slot of nums1). Compare and place the larger value at k, decrement. Copy remaining nums2 elements if any. |

### When to Use Two-Pointer Merge
- Merging two sorted arrays into one sorted result
- One array has extra space at the end (in-place merge)
- Need O(m + n) time without an auxiliary array
