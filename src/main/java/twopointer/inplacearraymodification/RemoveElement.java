package twopointer.inplacearraymodification;

/**
 Problem: Given an integer array nums and an integer val, remove all occurrences of val
  in-place. Return the number of elements not equal to val (k). The first k elements of
  nums should contain the elements that are not equal to val.

 Example:
    Input:  nums = [0, 1, 2, 2, 3, 0, 4, 2], val = 2
    Output: 5  (nums becomes [0, 1, 3, 0, 4, ...])

 Logic:
    1. Use a slow pointer (k) to track the write position for non-val elements.
    2. Iterate with a fast pointer (i) through the array.
    3. If nums[i] != val, copy it to position k and increment k.
    4. After the loop, k is the count of remaining elements.

 Time Complexity:  O(n) — single pass through the array.
 Space Complexity: O(1) — in-place modification with no extra data structures.
 */
public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        // k tracks the write position for elements to keep
        int k = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                // Current element is not the target — keep it at position k
                nums[k] = nums[i];
                k++;
            }
         }
        return k;
    }

    public static int removeElementClean(int[] nums, int val) {
        int k = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        System.out.println(removeElement(nums, val));
    }
}
