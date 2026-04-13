package twopointer.converging;

/**
 Problem: Given n non-negative integers where each represents a vertical line at position i
  with height height[i], find two lines that together with the x-axis form a container
  that holds the most water.

 Example:
    Input:  [1, 8, 6, 2, 5, 4, 8, 3, 7]
    Output: 49

 Logic:
    1. Place two pointers at the start (i) and end (j) of the array.
    2. Calculate the area formed between the two lines: min(height[i], height[j]) * (j - i).
    3. Track the maximum area seen so far.
    4. Move the pointer pointing to the shorter line inward, since moving the taller
       one can never increase the area (the width shrinks and height is bounded by the shorter).
    5. Repeat until the pointers meet.

  Time Complexity:  O(n) — single pass with two converging pointers.
  Space Complexity: O(1) — only a few variables used.
 */
public class ContainerIWithMostWater {

  public static int maxArea(int[] height) {
    int maxWater = Integer.MIN_VALUE;
    // Initialize two pointers at opposite ends of the array
    int i = 0, j = height.length - 1;

    while(i < j) {
      // The container height is limited by the shorter line
      int length = Math.min(height[i], height[j]);
      // The width is the distance between the two pointers
      int breadth = j - i;
      // Calculate area and update the maximum
      int area = length * breadth;
      maxWater = Math.max(maxWater, area);

      // Move the pointer at the shorter line inward to try for a taller container
      if(height[i] < height[j]) {
        i++;
      } else {
        j--;
      }
    }
    return maxWater;
  }

  public static int maxAreaClean(int[] height) {
    int maxWater = Integer.MIN_VALUE;
    int i = 0, j = height.length - 1;
    while(i < j) {
      int length = Math.min(height[i], height[j]);
      int breadth = j - i;
      int area = length * breadth;
      maxWater = Math.max(maxWater, area);
      if(height[i] < height[j]) {
        i++;
      } else {
        j--;
      }
    }
    return maxWater;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
    System.out.println(maxArea(arr));
    arr = new int[]{1,1};
    System.out.println(maxArea(arr));
  }

}
