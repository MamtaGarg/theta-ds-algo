package twopointer.converging;

import java.util.Arrays;

/**
 * Problem: Given a 1-indexed sorted array of integers and a target value, find two numbers
  that add up to the target. Return their 1-based indices as [index1, index2].
  Each input has exactly one solution, and you may not use the same element twice.

 * Example:
    Input:  numbers = [2, 3, 4], target = 6
    Output: [1, 3]

 * Logic:
    1. Place two pointers at the start (i) and end (j) of the sorted array.
    2. Compute the sum of the elements at both pointers.
    3. If sum == target, return their 1-based indices.
    4. If sum > target, move the right pointer left to reduce the sum.
    5. If sum < target, move the left pointer right to increase the sum.

 * Time Complexity:  O(n) — single pass with two converging pointers.
 * Space Complexity: O(1) — only pointer variables used.
 */
public class TwoSum {

    public static int[] twoSum(int[] numbers, int target) {
        // Initialize two pointers at both ends of the sorted array
        int i = 0, j = numbers.length - 1;

        while(i < j) {
            // Compute the sum of the pair
            int sum =  numbers[i] + numbers[j];

            if(sum == target) {
                // Found the pair — return 1-based indices
                return new int[]{i + 1, j + 1};
            } else if(sum > target) {
                // Sum too large — move right pointer left to decrease it
                j--;
            } else {
                // Sum too small — move left pointer right to increase it
                i++;
            }
        }
        // No valid pair found
        return new int[]{};
    }

    public static int[] twoSumClean(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while(i < j) {
            int sum = numbers[i] + numbers[j];
            if(sum == target) {
                return new int[]{i + 1, j + 1};
            } else if(sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        //int[] arr = new int[]{2, 7, 11, 15};
        int[] arr = new int[]{2,3,4};
        int target = 3;
        System.out.println(Arrays.toString(twoSum(arr, target)));
    }
}
