package linkedlistManipulationPattern.intersectiondetection;

import java.util.*;

public class MinimumIndexOfTwoSum {

    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();

        // Step 1: store list1 indices
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        List<String> result = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;

        // Step 2: traverse list2
        for (int j = 0; j < list2.length; j++) {
            String str = list2[j];

            if (map.containsKey(str)) {
                int sum = j + map.get(str);

                if (sum < minSum) {
                    minSum = sum;
                    result.clear();
                    result.add(str);
                } else if (sum == minSum) {
                    result.add(str);
                }
            }
        }

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] str1 = new String[]{"happy","sad","good"};
        String[] str2 = new String[]{"sad","happy","good"};
        System.out.println(Arrays.toString(findRestaurant(str1, str2)));
    }
}
