package twopointer.inplacearraymodification;

import java.util.Arrays;

/**
 Problem: Given an integer array nums, move all 0's to the end while maintaining
  the relative order of the non-zero elements. Must be done in-place.

 Example:
    Input:  [0, 1, 0, 3, 12]
    Output: [1, 3, 12, 0, 0]

 Logic:
    1. Use a slow pointer (k) to track the position where the next non-zero element should go.
    2. Iterate with a fast pointer (i) through the array.
    3. When a non-zero element is found, swap it with the element at position k, then advance k.
    4. This pushes all zeros to the end while preserving the order of non-zero elements.

 Time Complexity:  O(n) — single pass through the array.
 Space Complexity: O(1) — in-place swaps with no extra data structures.
 */
public class MoveZeros {

    public static void moveZeroes(int[] nums) {
        // k tracks the position for the next non-zero element
        int k = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                // Swap current non-zero element into position k
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                // Advance the placement pointer
                k++;
            }
        }
    }

    public static void moveZeroesClean(int[] nums) {
        int k = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                k++;
            }
        }
    }

    public static void main(String[] args) {
        //int[] arr = new int[]{0,1,0,3,12};
        int[] arr = new int[]{1};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}