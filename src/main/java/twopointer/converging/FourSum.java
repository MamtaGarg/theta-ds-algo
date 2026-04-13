package twopointer.converging;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
  Problem: Given an array nums of n integers and an integer target, return all unique
  quadruplets [nums[a], nums[b], nums[c], nums[d]] such that
  a, b, c, d are distinct indices and nums[a] + nums[b] + nums[c] + nums[d] == target.
  The solution set must not contain duplicate quadruplets.

  Example:
    Input:  nums = [1, 0, -1, 0, -2, 2], target = 0
    Output: [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]

  Logic:
    1. Sort the array to enable two-pointer technique and duplicate skipping.
    2. Fix the first element (i) and second element (j) with two nested loops.
    3. For the remaining sub-array, use two converging pointers (left, right) to find
       pairs that complete the quadruplet summing to target.
    4. Skip duplicates at every level (i, j, left, right) to avoid duplicate quadruplets.
    5. Use long for the sum to avoid integer overflow.

  Time Complexity:  O(n³) — two nested loops O(n²) with a two-pointer pass O(n) inside.
  Space Complexity: O(n) — for sorting overhead, excluding the output list.
 */
public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        // Sort to enable two-pointer approach and duplicate skipping
        Arrays.sort(nums);

        // Fix the first element of the quadruplet
        for(int i = 0; i < nums.length - 3; i++) {
            // Skip duplicate values for the first element
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            // Fix the second element of the quadruplet
            for(int j = i + 1; j < nums.length - 2; j++) {
                // Skip duplicate values for the second element
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;

                // Initialize two converging pointers for the remaining sub-array
                int left = j + 1, right = nums.length - 1;

                while(left < right) {
                    // Use long to prevent integer overflow on large values
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if(sum == target) {
                        // Found a valid quadruplet — add it to results
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Skip duplicate values on the left pointer
                        while(left < right && nums[left] == nums[left + 1]) left++;
                        // Skip duplicate values on the right pointer
                        while(left < right && nums[right] == nums[right - 1]) right--;

                        // Move both pointers inward after processing duplicates
                        left++;
                        right--;
                    } else if(sum > target) {
                        // Sum too large — move right pointer left to decrease it
                        right--;
                    } else {
                        // Sum too small — move left pointer right to increase it
                        left++;
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> fourSumClean(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < nums.length - 2; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1, right = nums.length - 1;
                while(left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left + 1]) left++;
                        while(left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if(sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(fourSum(arr, target));
    }
}
