package twopointer.converging;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletsWithSumZero {

    public static List<List<Integer>> threeSum(int[] nums) {
      Arrays.sort(nums);

      List<List<Integer>> results = new ArrayList<>();

      for(int i = 0; i < nums.length - 2; i++) {
        int left = i + 1, right = nums.length - 1;

        // skip initial duplicate
        if(i > 0 && nums[i] == nums[i - 1]) continue;

        while (left < right) {
          int sum = nums[left] + nums[right] + nums[i];

          if (sum == 0) {
            results.add(Arrays.asList(nums[i], nums[left], nums[right]));

            while (left < right && nums[left] == nums[left + 1])
              left++;
            while (left < right && nums[right] == nums[right - 1])
              right--;

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
      int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
      threeSum(nums).forEach(x -> System.out.println(x));
    }
}
