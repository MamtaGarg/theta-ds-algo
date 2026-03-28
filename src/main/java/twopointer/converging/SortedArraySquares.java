package twopointer.converging;

import java.util.Arrays;

public class SortedArraySquares {

  public static int[] sortedSquares(int[] nums) {
    int left = 0, right = nums.length - 1, index = nums.length - 1;
    int[] result = new int[index + 1];
    while(left <= right) {
      if(Math.abs(nums[left]) > Math.abs(nums[right])) {
        result[index] = nums[left] * nums[left];
        left++;
      } else {
        result[index] = nums[right] * nums[right];
        right--;
      }
      index--;
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{-4, -1, 0, 3, 10};
    System.out.println(Arrays.toString(sortedSquares(nums)));
  }
}
