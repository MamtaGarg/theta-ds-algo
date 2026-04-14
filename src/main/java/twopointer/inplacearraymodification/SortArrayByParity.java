package twopointer.inplacearraymodification;

import java.util.Arrays;

/**
 Problem: Given an integer array nums, move all even integers to the beginning
  followed by all odd integers. Any ordering within even/odd groups is acceptable.

 Example:
    Input:  [3, 1, 2, 4]
    Output: [2, 4, 3, 1]  (any order where evens come before odds)

 Logic:
    1. Use a slow pointer (k) to track the position for the next even element.
    2. Iterate with a fast pointer (i) through the array.
    3. When an even element is found, swap it with the element at position k, then advance k.
    4. This groups all evens at the front while odds drift to the back.

 Time Complexity:  O(n) — single pass through the array.
 Space Complexity: O(1) — in-place swaps with no extra data structures.
 */
public class SortArrayByParity {

    public static int[] sortArrayByParity(int[] nums) {
        // k tracks the position for the next even element
        int k = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0) {
                // Even element found — swap it into the even section at position k
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                // Advance the even-section boundary
                k++;
            }
        }
        return nums;
    }

    public static int[] sortArrayByParityClean(int[] nums) {
        int k = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0) {
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                k++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 2, 4};
        System.out.println(Arrays.toString(sortArrayByParity(arr)));
    }

}
