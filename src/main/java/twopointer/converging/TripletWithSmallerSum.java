package twopointer.converging;

import java.util.Arrays;

/**
 Problem: Given an array arr of unsorted numbers and a target sum, count all triplets
  in the array whose sum is less than the given target.

 Example:
    Input:  arr = [-1, 4, 2, 1, 3], target = 5
    Output: 4  (triplets: [-1,1,2], [-1,1,3], [-1,1,4], [-1,2,3])

 Logic:
    1. Sort the array to enable the two-pointer converging technique.
    2. Fix one element (arr[i]) and use two pointers (left, right) on the remaining sub-array.
    3. If the sum of the triplet < target, all elements between left and right paired
       with left also form valid triplets, so add (right - left) to count.
    4. Move left pointer right to explore other pairs.
    5. If the sum >= target, move right pointer left to decrease the sum.

 Time Complexity:  O(n²) — sorting is O(n log n) and the nested loop with two pointers is O(n²).
 Space Complexity: O(1) — only a few tracking variables used (excluding sort overhead).
 */
public class TripletWithSmallerSum {

    public static int searchTriplets(int[] arr, int target) {
        int count = 0, sum = 0;

        // Sort to enable two-pointer approach
        Arrays.sort(arr);

        // Fix the first element of the triplet
        for(int i = 0; i < arr.length - 2; i++) {
            int left = i + 1, right = arr.length - 1;

            while(left < right) {
                 sum = arr[i] + arr[left] + arr[right];
                if(sum < target) {
                    // All pairs (left, left+1...right) with current left are valid
                    count += right - left;
                    // Move left pointer right to explore next set of pairs
                    left++;
                } else {
                    // Sum too large — move right pointer left to decrease it
                    right--;
                }
            }
        }

        return count;
    }

    public static int searchTripletsClean(int[] arr, int target) {
        int count = 0, sum = 0;
        Arrays.sort(arr);
        for(int i = 0; i < arr.length - 2; i++) {
            int left = i + 1, right = arr.length - 1;
            while(left < right) {
                sum = arr[i] + arr[left] + arr[right];
                if(sum < target) {
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        //int[] arr = new int[]{-1, 0, 2, 3};
        int[] arr = new int[]{-1, 4, 2, 1, 3};
        int target = 5;
        System.out.println(searchTriplets(arr, target));
    }
}
