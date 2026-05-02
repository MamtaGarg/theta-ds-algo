package hash;

import java.util.*;

/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

Example 3:
Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2
Output: [1,2]

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/
public class TopKFrequentElements {

    public static List<Integer> topKFrequent(int[] nums, int k) {

        // Step 1: Count frequency
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create buckets (index = frequency)
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            buckets.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            buckets.get(freq).add(num);
        }

        // Step 3: Collect top k frequent elements
        List<Integer> result = new ArrayList<>();
        for (int i = buckets.size() - 1; i >= 0 && result.size() < k; i--) {
            for (int num : buckets.get(i)) {
                result.add(num);
                if (result.size() == k) {
                    return result;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[]{1,1,1,2,2,3}, 2)); // [1,2]
        System.out.println(topKFrequent(new int[]{1}, 1));           // [1]
        System.out.println(topKFrequent(
                new int[]{1,2,1,2,1,2,3,1,3,2}, 2)); // [1,2]
    }
}
