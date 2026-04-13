package twopointer.converging;

import java.util.Arrays;

/**
 * Problem: Given an integer array nums sorted in non-decreasing order, return an array of
  the squares of each number, also sorted in non-decreasing order.
  The array may contain negative numbers whose squares could be larger than positive elements.

 * Example:
    Input:  [-4, -1, 0, 3, 10]
    Output: [0, 1, 9, 16, 100]

 * Logic:
    1. Use two pointers: left at the start, right at the end of the sorted array.
    2. Compare absolute values at both pointers — the larger absolute value produces
       the larger square.
    3. Place the larger square at the current end of the result array (fill from right to left).
    4. Move the pointer that had the larger absolute value inward.
    5. Decrement the result index and repeat until all elements are placed.

 * Time Complexity:  O(n) — single pass with two converging pointers.
 * Space Complexity: O(n) — for the result array.
 */
public class SortedArraySquares {

  public static int[] sortedSquares(int[] nums) {
    // Two pointers at opposite ends; index fills result from the largest position
    int left = 0, right = nums.length - 1, index = nums.length - 1;
    int[] result = new int[index + 1];

    while(left <= right) {
      if(Math.abs(nums[left]) > Math.abs(nums[right])) {
        // Left element has a larger absolute value — its square goes at current index
        result[index] = nums[left] * nums[left];
        left++;
      } else {
        // Right element has a larger (or equal) absolute value — its square goes at current index
        result[index] = nums[right] * nums[right];
        right--;
      }
      // Move to the next position (right to left) in the result array
      index--;
    }
    return result;
  }

  public static int[] sortedSquaresClean(int[] nums) {
    int left = 0, right = nums.length - 1, index = nums.length - 1;
    int[] result = new int[index + 1];
    while(left <= right) {
      if(Math.abs(nums[left]) > Math.abs(nums[right])) {
        result[index] = nums[left] * nums[left];
        left++;
      } else {
        result[index] = nums[right] * nums[right];
        right--;
      }
      index--;
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{-4, -1, 0, 3, 10};
    System.out.println(Arrays.toString(sortedSquares(nums)));
  }
}
