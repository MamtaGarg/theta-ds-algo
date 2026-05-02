package mergeIntervals;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/* Tesco Interview
Given a list of intervals representing the start and end time of ‘N’ meetings, find the minimum number of rooms required to hold all the meetings.

Example 1:

Meetings: [[1,4], [2,5], [7,9]]
Output: 2
Explanation: Since [1,4] and [2,5] overlap, we need two rooms to hold these two meetings. [7,9] can occur in any of the two rooms later.
Example 2:

Meetings: [[6,7], [2,4], [8,12]]
Output: 1
Explanation: None of the meetings overlap, therefore we only need one room to hold all meetings.
Example 3:

Meetings: [[1,4], [2,3], [3,6]]
*/
public class MinimumMeetingRooms {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,4}, {2,5}, {7,9}};
        System.out.println(findMinimumMeetingRooms(arr));
    }

    private static int findMinimumMeetingRooms(int[][] arr) {
        if (arr.length == 0) return 0;

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int maxRooms = 0;
        for (int[] meeting : arr) {
            // Free rooms that have ended
            while (!minHeap.isEmpty() && minHeap.peek() <= meeting[0]) { // no overlapping
                minHeap.poll();
            }

            // Allocate room
            minHeap.offer(meeting[1]);
            maxRooms = Math.max(maxRooms, minHeap.size());
        }

        return maxRooms;
    }
}
