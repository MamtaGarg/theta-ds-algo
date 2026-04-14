package twopointer.converging;

import java.util.Arrays;

/**
 Problem: Given an array people[] where people[i] is the weight of the i-th person,
  and a boat weight limit, find the minimum number of boats required.
  Each boat can carry at most two people, provided their combined weight <= limit.

 Example:
    Input:  people = [1, 2], limit = 3
    Output: 1

 Logic:
    1. Sort the array so lightest and heaviest people are at opposite ends.
    2. Use two converging pointers: i (lightest) and j (heaviest).
    3. If the lightest and heaviest can share a boat (sum <= limit), move both pointers inward.
    4. Otherwise, the heaviest person rides alone — move only j inward.
    5. Increment boat count each iteration. Continue until pointers cross.

 Time Complexity:  O(n log n) — dominated by the sort; the two-pointer pass is O(n).
 Space Complexity: O(1) — sorting in-place, only pointer variables used.
 */
public class BoatToSavePeople {

    public static int numRescueBoats(int[] people, int limit) {
        // Sort so we can pair lightest with heaviest
        Arrays.sort(people);

        int boatCount = 0;
        // Two pointers: lightest person (i) and heaviest person (j)
        int i = 0, j = people.length - 1;

        while(i <= j) {
            // If lightest and heaviest can share a boat, move lightest pointer inward
            if(people[i] + people[j] <= limit) {
                i++;
            }
            // Heaviest always boards a boat — move heaviest pointer inward
            j--;
            boatCount++;
        }
        return boatCount;
    }

    public static int numRescueBoatsClean(int[] people, int limit) {
        Arrays.sort(people);
        int boatCount = 0;
        int i = 0, j = people.length - 1;
        while(i <= j) {
            if(people[i] + people[j] <= limit) {
                i++;
            }
            j--;
            boatCount++;
        }
        return boatCount;
    }

    public static void main(String[] args) {
        //int[] arr = new int[]{3, 5, 3, 4}; // [3, 3, 4, 5] // [1, 2, 2, 3]
        //int[] arr = new int[]{3, 2, 2, 1}; // [3, 3, 4, 5] // [1, 2, 2, 3]
        int[] arr = new int[]{1, 2}; // [3, 3, 4, 5] // [1, 2, 2, 3]
        int limit = 3; // 3
        System.out.println(numRescueBoats(arr, limit));
    }
}
