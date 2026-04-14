package twopointer.converging;

import java.util.Arrays;

/**
 Problem: Given an integer array nums and a target, find three integers in nums such that
  their sum is closest to target. Return the sum of the three integers.
  Each input has exactly one solution.

 Example:
    Input:  nums = [-1, 2, 1, -4], target = 1
    Output: 2  (because -1 + 2 + 1 = 2)

 Logic:
    1. Sort the array to enable the two-pointer converging technique.
    2. Fix one element (nums[i]) and use two pointers (left, right) on the remaining sub-array.
    3. Compute the current sum and compare its distance to target with the closest sum so far.
    4. If currentSum < target, move left pointer right to increase the sum.
    5. If currentSum > target, move right pointer left to decrease the sum.
    6. If currentSum == target, return immediately — exact match found.

 Time Complexity:  O(n²) — sorting is O(n log n) and the nested loop with two pointers is O(n²).
 Space Complexity: O(1) — only a few tracking variables used (excluding sort overhead).
 */
public class ThreeSumCloset {

    public static int threeSumClosest(int[] nums, int target) {
        // Sort to enable two-pointer approach
        Arrays.sort(nums);
        // Initialize closest sum with the first three elements
        int closestNumber = nums[0] + nums[1] + nums[2] ;

        // Fix the first element and search for the best pair
        for(int i = 0; i < nums.length - 2; i++) {

            int left = i + 1, right = nums.length - 1;

            while(left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                // Update closest sum if current is nearer to target
                if (Math.abs(currentSum - target) < Math.abs(closestNumber - target)) {
                    closestNumber = currentSum;
                }

                if(currentSum < target) {
                    // Sum too small — move left pointer right to increase it
                    left++;
                } else if(currentSum > target){
                    // Sum too large — move right pointer left to decrease it
                    right--;
                } else
                  // Exact match — no closer sum possible
                  return currentSum;
            }
        }
        return closestNumber;
    }

    public static int threeSumClosestClean(int[] nums, int target) {
        Arrays.sort(nums);
        int closestNumber = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while(left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                if (Math.abs(currentSum - target) < Math.abs(closestNumber - target)) {
                    closestNumber = currentSum;
                }
                if(currentSum < target) {
                    left++;
                } else if(currentSum > target) {
                    right--;
                } else
                    return currentSum;
            }
        }
        return closestNumber;
    }

    public static void main(String[] args) {
        //int[] nums = new int[]{-1, 2, 1, -4};
        int[] nums = new int[]{0, 0, 0};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));

    }
}
