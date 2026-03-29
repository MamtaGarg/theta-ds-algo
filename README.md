| Algorithm Name                                                                                                             | Pattern            | Sub-pattern | Description                                                                           | Time Complexity | Space Complexity | Special Cases |
|----------------------------------------------------------------------------------------------------------------------------|--------------------|-------------|---------------------------------------------------------------------------------------|----------------|------------------|----------------|
| [SortedArraySquares](https://github.com/MamtaGarg/theta-ds-algo/blob/main/src/main/java/com.theta/SortedArraySquares.java) | Two Pointer        | Converging  | Given a sorted array, return an array of squares of each number, also sorted. [Leetcode](https://leetcode.com/problems/squares-of-a-sorted-array/description/) | O(n)  | O(n)             |  |
| [TripletsWithSumZero](https://github.com/MamtaGarg/theta-ds-algo/blob/main/src/main/java/twopointer/converging/TripletsWithSumZero.java) | Two Pointer        | Converging  | Given an array of integers, find all unique triplets that sum to zero. [Leetcode](https://leetcode.com/problems/3sum/description/) | O(n²) | O(n)             |  Skip duplicates for all 3 pointers
// starting pointer
if(i > 0 && nums[i] == nums[i - 1]) continue;
// left pointer
while (left < right && nums[left] == nums[left + 1])
      left++;
// right pointer
while (left < right && nums[right] == nums[right - 1])
      right--;|
