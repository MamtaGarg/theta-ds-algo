package greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:

numberOfBoxesi is the number of boxes of type i.
numberOfUnitsPerBoxi is the number of units in each box of the type i.
You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck. You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.

Return the maximum total number of units that can be put on the truck.


Example 1:

Input: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
Output: 8
Explanation: There are:
- 1 box of the first type that contains 3 units.
- 2 boxes of the second type that contain 2 units each.
- 3 boxes of the third type that contain 1 unit each.
You can take all the boxes of the first and second types, and one box of the third type.
The total number of units will be = (1 * 3) + (2 * 2) + (1 * 1) = 8.
Example 2:

Input: boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
Output: 91


Constraints:

1 <= boxTypes.length <= 1000
1 <= numberOfBoxesi, numberOfUnitsPerBoxi <= 1000
1 <= truckSize <= 106
*/
public class MaxUnitsOnTruck {

    // Time Complexity - O(n log n)(because of Sorting), Space Complexity - O(log n)(due to sorting recursion stack)
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int totalUnits = 0, index = 0;
        while(index < boxTypes.length && truckSize > 0) {
            int maxBoxTaken = Math.min(truckSize, boxTypes[index][0]);
            totalUnits += boxTypes[index][1] * maxBoxTaken;
            truckSize -= maxBoxTaken;
            index++;
        }
        return totalUnits;
    }


    // Time Complexity - O(n) , Space Complexity - O(1)
    public static int maximumUnitsForMaxUnitsPerBox(int[][] boxTypes, int truckSize) {
        int[] buckets = new int[1001]; // index = units per box

        for (int[] box : boxTypes) {
            buckets[box[1]] += box[0];
        }

        int totalUnits = 0;

        for (int units = 1000; units >= 0 && truckSize > 0; units--) {
            if (buckets[units] == 0) continue;

            int boxes = Math.min(truckSize, buckets[units]);
            totalUnits += boxes * units;
            truckSize -= boxes;
        }

        return totalUnits;
    }

    // Time Complexity - O(n log n)(Insert all elements → O(n log n), Poll up to n elements → O(n log n)),
    // Space Complexity - O(n)(Heap stores all elements)
    public int maximumUnitsUsingPriorityQueue(int[][] boxTypes, int truckSize) {

        // Max heap based on units per box
        PriorityQueue<int[]> maxHeap =
                new PriorityQueue<>((a, b) -> b[1] - a[1]);

        // Add all box types
        for (int[] box : boxTypes) {
            maxHeap.offer(box);
        }

        int totalUnits = 0;

        while (!maxHeap.isEmpty() && truckSize > 0) {
            int[] box = maxHeap.poll();

            int boxesAvailable = box[0];
            int unitsPerBox = box[1];

            int boxesTaken = Math.min(truckSize, boxesAvailable);

            totalUnits += boxesTaken * unitsPerBox;
            truckSize -= boxesTaken;
        }

        return totalUnits;
    }

    public static void main(String[] args) {
        int[][] boxTypes = new int[][]{{1,3},{2,2},{3,1}};
        int truckSize = 4;

        System.out.println("Maximum Units on a truck : " + maximumUnits(boxTypes, truckSize));
    }
}
