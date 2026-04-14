package twopointer.inplacearraymodification;

/**
 Problem: Given a sorted array nums, remove the duplicates in-place such that each element
  appears only once. Return the number of unique elements (k). The first k elements of nums
  should hold the unique values in their original order.

 Example:
    Input:  [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
    Output: 5  (nums becomes [0, 1, 2, 3, 4, ...])

 Logic:
    1. The first element is always unique, so start the write pointer k at 1.
    2. Iterate from index 1 with a fast pointer (i).
    3. If nums[i] differs from nums[k-1] (the last written unique value),
       write nums[i] at position k and increment k.
    4. After the loop, k is the count of unique elements.

 Time Complexity:  O(n) — single pass through the array.
 Space Complexity: O(1) — in-place modification with no extra data structures.
 */
public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        // Edge case: empty array
        if (nums.length == 0) return 0;

        // k points to the next write position; first element is always unique
        int k = 1;

        for (int i = 1; i < nums.length; i++) {
            // If current element differs from the last unique element, it's a new unique value
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    public static int removeDuplicatesClean(int[] nums) {
        if (nums.length == 0) return 0;
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(arr));
    }
}
