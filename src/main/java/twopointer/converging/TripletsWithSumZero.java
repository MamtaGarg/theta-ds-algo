package twopointer.converging;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Problem: Given an integer array nums, return all unique triplets [nums[i], nums[j], nums[k]]
  such that i != j != k and nums[i] + nums[j] + nums[k] == 0.
  The solution set must not contain duplicate triplets.

 * Example:
    Input:  [-1, 0, 1, 2, -1, -4]
    Output: [[-1, -1, 2], [-1, 0, 1]]

 * Logic:
    1. Sort the array so we can use the two-pointer converging technique and easily skip duplicates.
    2. Fix one element (nums[i]) and use two pointers (left, right) on the remaining sub-array
       to find pairs that sum to -nums[i].
    3. If the current sum == 0, record the triplet and advance both pointers while skipping duplicates.
    4. If the sum > 0, move the right pointer left to decrease the sum.
    5. If the sum < 0, move the left pointer right to increase the sum.

 * Time Complexity:  O(n²) — sorting is O(n log n) and the nested loop with two pointers is O(n²).
 * Space Complexity: O(n) — for the sorting overhead (depends on implementation), excluding the output list.
 */
public class TripletsWithSumZero {

    public static List<List<Integer>> threeSum(int[] nums) {
      // Sort to enable two-pointer approach and duplicate skipping
      Arrays.sort(nums);

      List<List<Integer>> results = new ArrayList<>();

      // Iterate through each element as the fixed first value of the triplet
      for(int i = 0; i < nums.length - 2; i++) {
        // Initialize two converging pointers for the remaining sub-array
        int left = i + 1, right = nums.length - 1;

        // Skip duplicate values for the fixed element to avoid duplicate triplets
        if(i > 0 && nums[i] == nums[i - 1]) continue;

        while (left < right) {
          // Calculate the sum of the current triplet
          int sum = nums[left] + nums[right] + nums[i];

          if (sum == 0) {
            // Found a valid triplet — add it to results
            results.add(Arrays.asList(nums[i], nums[left], nums[right]));

            // Skip duplicate values on the left pointer
            while (left < right && nums[left] == nums[left + 1])
              left++;
            // Skip duplicate values on the right pointer
            while (left < right && nums[right] == nums[right - 1])
              right--;

            // Move both pointers inward after processing duplicates
            left++;
            right--;
          } else if (sum > 0) {
            // Sum too large — move right pointer left to decrease it
            right--;
          } else {
            // Sum too small — move left pointer right to increase it
            left++;
          }
        }
      }
      return results;
    }

    public static List<List<Integer>> threeSumClean(int[] nums) {
      Arrays.sort(nums);
      List<List<Integer>> results = new ArrayList<>();

      for (int i = 0; i < nums.length - 2; i++) {
        int left = i + 1, right = nums.length - 1;
        if (i > 0 && nums[i] == nums[i - 1]) continue;

        while (left < right) {
          int sum = nums[left] + nums[right] + nums[i];

          if (sum == 0) {
            results.add(Arrays.asList(nums[i], nums[left], nums[right]));
            while (left < right && nums[left] == nums[left + 1]) left++;
            while (left < right && nums[right] == nums[right - 1]) right--;
            left++;
            right--;
          } else if (sum > 0) {
            right--;
          } else {
            left++;
          }
        }
      }
      return results;
    }

    public static void main(String[] args) {
      int[] nums = new int[]{-1, 0, 1, 2, -1, -4}; // Sorted array - {-4, -1, -1, 0, 1, 2}
      threeSum(nums).forEach(x -> System.out.println(x));
    }
}
