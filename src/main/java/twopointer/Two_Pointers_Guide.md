# Two Pointers Guide

---

## Two Pointers — Converging Pattern

> **Core idea:** Start pointers at both ends of a sorted (or indexable) structure, move them inward based on a condition until they meet.

### Problems

| # | Problem Statement | Time | Space | Logic |
|---|---|---|---|---|
| 1 | [Two Sum (Sorted Array)](https://github.com/MamtaGarg/theta-ds-algo/tree/main/src/main/java/twopointer/converging/TwoSum.java) | O(n) | O(1) | Two converging pointers at both ends; adjust based on whether current sum is above or below target. |
| 2 | [Triplets With Sum Zero (3Sum)](https://github.com/MamtaGarg/theta-ds-algo/tree/main/src/main/java/twopointer/converging/TripletsWithSumZero.java) | O(n²) | O(n) | Sort + fix one element, two-pointer on the rest to find pairs summing to −nums[i]. Skip duplicates at 3 places. |
| 3 | [Three Sum Closest](https://github.com/MamtaGarg/theta-ds-algo/tree/main/src/main/java/twopointer/converging/ThreeSumCloset.java) | O(n²) | O(1) | Same as 3Sum but track closest sum via `abs(currentSum - target) < abs(closestNumber - target)`. |
| 4 | [Four Sum](https://github.com/MamtaGarg/theta-ds-algo/tree/main/src/main/java/twopointer/converging/FourSum.java) | O(n³) | O(n) | Sort, fix two elements with nested loops, two converging pointers for the remaining pair. Skip duplicates at every level. Uses `long` to avoid overflow. |
| 5 | [Triplet With Smaller Sum](https://github.com/MamtaGarg/theta-ds-algo/tree/main/src/main/java/twopointer/converging/TripletWithSmallerSum.java) | O(n²) | O(1) | Sort, fix one element, two pointers; when sum < target, all pairs between left and right are valid → count += right − left. |
| 6 | [Container With Most Water](https://github.com/MamtaGarg/theta-ds-algo/tree/main/src/main/java/twopointer/converging/ContainerIWithMostWater.java) | O(n) | O(1) | Area = min(h[left], h[right]) × (right − left). Always move the shorter side inward. |
| 7 | [Sorted Array Squares](https://github.com/MamtaGarg/theta-ds-algo/tree/main/src/main/java/twopointer/converging/SortedArraySquares.java) | O(n) | O(n) | Largest squares are at edges (big negatives left, big positives right). Compare absolute values, fill result from right to left. |
| 8 | [Max Profit By Buy And Sell Stock](https://github.com/MamtaGarg/theta-ds-algo/tree/main/src/main/java/twopointer/converging/MaxProfitByBuyAndSellStock.java) | O(n) | O(1) | Track minimum price seen so far; update max profit for each subsequent day. |
| 9 | [Boats to Save People](https://github.com/MamtaGarg/theta-ds-algo/tree/main/src/main/java/twopointer/converging/BoatToSavePeople.java) | O(n log n) | O(1) | Sort by weight, pair lightest with heaviest; heaviest always boards, lightest joins only if combined weight fits. |

### When to Use Converging Two Pointers
- Array is sorted (or problem benefits from sorting first)
- Looking for pairs/triplets/quadruplets that satisfy a sum condition
- Need to compare elements from both ends (palindrome, container)
- Want O(1) space instead of a hash map

---

## Two Pointers — String Reversal Pattern

> **Core idea:** Two pointers at both ends, swap and move inward. Variation: skip certain characters, or reverse in chunks (whole string → per word).

### Problems

| # | Problem Statement | Time | Space | Logic |
|---|---|---|---|---|
| 1 | [Reverse String](https://github.com/MamtaGarg/theta-ds-algo/tree/main/src/main/java/twopointer/stringreversal/ReverseString.java) | O(n) | O(1) | Two pointers from ends, swap and move inward. In-place. |
| 2 | [Reverse Vowels of a String](https://github.com/MamtaGarg/theta-ds-algo/tree/main/src/main/java/twopointer/stringreversal/ReverseVowel.java) | O(n) | O(n) | Two pointers from ends, each skips non-vowels. When both land on vowels → swap. |
| 3 | [Reverse First K Characters](https://github.com/MamtaGarg/theta-ds-algo/tree/main/src/main/java/twopointer/stringreversal/ReverseKCharacters.java) | O(n) | O(n) | Iterate in 2k steps; apply two-pointer swap on the first k characters of each chunk. |
| 4 | [Reverse Words (With Extra Space)](https://github.com/MamtaGarg/theta-ds-algo/tree/main/src/main/java/twopointer/stringreversal/ReverseWordsWithExtraSpace.java) | O(n) | O(n) | Split by whitespace, two-pointer swap the word array, join with single space. |
| 5 | [Reverse Words (Without Extra Space)](https://github.com/MamtaGarg/theta-ds-algo/tree/main/src/main/java/twopointer/stringreversal/ReverseStringWithoutExtraSpace.java) | O(n) | O(n) | Reverse entire char array, then reverse each word individually, clean up extra spaces. Two-pass reverse trick. |

### When to Use String Reversal Two Pointers
- Need to reverse in-place (no extra string allocation)
- Reverse selectively — only vowels, only words, skip certain chars
- Trick: reverse twice (whole + parts) to reorder segments

---

## Two Pointers — In-place Array Modification Pattern

> **Core idea:** Use a slow/write pointer to build the result in-place while a fast/scan pointer reads through the array. No extra array needed.

### Problems

| # | Problem Statement | Time | Space | Logic |
|---|---|---|---|---|
| 1 | [Remove Element](https://github.com/MamtaGarg/theta-ds-algo/tree/main/src/main/java/twopointer/inplacearraymodification/RemoveElement.java) | O(n) | O(1) | Slow pointer collects non-target elements as fast pointer scans the array. |
| 2 | [Remove Duplicates From Sorted Array](https://github.com/MamtaGarg/theta-ds-algo/tree/main/src/main/java/twopointer/inplacearraymodification/RemoveDuplicatesFromSortedArray.java) | O(n) | O(1) | Write pointer starts at 1. If nums[i] != nums[k−1] → write it and advance k. |
| 3 | [Move Zeros](https://github.com/MamtaGarg/theta-ds-algo/tree/main/src/main/java/twopointer/inplacearraymodification/MoveZeros.java) | O(n) | O(1) | Slow = write pointer. If non-zero → swap with slow, advance. Zeros end up at the back. |
| 4 | [Sort Array By Parity](https://github.com/MamtaGarg/theta-ds-algo/tree/main/src/main/java/twopointer/inplacearraymodification/SortArrayByParity.java) | O(n) | O(1) | Slow pointer tracks even-section boundary; swap even elements to the front as fast pointer scans. |

### When to Use In-place Array Modification
- Problem says "modify in-place" or "return new length"
- Need to partition elements (remove, move, sort by category)
- Write pointer builds the clean result while scan pointer reads ahead
