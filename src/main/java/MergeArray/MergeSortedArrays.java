package MergeArray;

import java.util.Arrays;

/**
 * Problem: Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1
  as one sorted array. nums1 has enough space (size m + n) to hold the additional elements.

 * Example:
    Input:  nums1 = [2, 5, 6, 0, 0, 0], m = 3, nums2 = [1, 2, 3], n = 3
    Output: [1, 2, 2, 3, 5, 6]

 * Logic:
    1. Start three pointers from the end: i at last valid element of nums1, j at end of nums2,
       k at the last position of nums1.
    2. Compare nums1[i] and nums2[j]; place the larger value at nums1[k] and decrement that pointer.
    3. If nums2 has remaining elements after nums1 is exhausted, copy them into nums1.
    4. No need to handle leftover nums1 elements — they are already in place.

 * Time Complexity:  O(m + n) — each element is visited at most once.
 * Space Complexity: O(1) — merging is done in-place within nums1.
 */
public class MergeSortedArrays {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // Pointers: i = end of nums1 data, j = end of nums2, k = end of merged array
        int  i = m - 1, j = n -1, k = m + n - 1;

        // Merge from the back — place the larger element at position k
        while(i >= 0 && j >= 0) {
            if(nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                k--; i--;
            } else {
                nums1[k] = nums2[j];
                k--; j--;
            }
        }
        // Copy any remaining elements from nums2 (nums1 leftovers are already in place)
        while(j >= 0) {
            nums1[k] = nums2[j];
            k--; j--;
        }
    }

    public static void mergeClean(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while(i >= 0 && j >= 0) {
            if(nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                k--; i--;
            } else {
                nums1[k] = nums2[j];
                k--; j--;
            }
        }
        while(j >= 0) {
            nums1[k] = nums2[j];
            k--; j--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2,5,6,0,0,0};
        int[] nums2 = new int[]{1,2,3};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
