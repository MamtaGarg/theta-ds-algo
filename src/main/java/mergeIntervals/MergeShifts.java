package mergeIntervals;

/*
* Tesco has around 3200 stores and more than 10% of the stores have around 800 colleagues each.

In a store, a colleague can work for multiple departments. Here are shifts of a colleague in various departments:


In Checkout department: From 10 to 12

In Bakery department: From 8 to 10

In Diary department: From 14 to 19


Given the above split of shifts, provide an API/method to return the different shifts of a colleague for the day after merging contiguous shifts. This will be exposed to the colleague in different UI and help them plan their day accordingly.

His shift timings in this case are 8 to 12 and 14 to 19.

* */
// [[8, 10], [10,12] [14, 19]]

import java.util.*;

public class MergeShifts {

    static class Interval {
        int start;
        int end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        List<Interval> intervals = new LinkedList<>();
        intervals.add(new Interval(10, 12));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(14, 19));
        List<Interval> result = generateShifts(intervals);
        result.stream().forEach(x -> System.out.println(x.start  + " " + x.end));

        int[][] shifts = new int[][]{{10, 12},{8, 10},{14, 19}};

        int[][] mergedShifts = merge(shifts);
        System.out.println(Arrays.deepToString(mergedShifts));
    }

    private static List<Interval> generateShifts(List<Interval> list) {
        if (list == null || list.size() <= 1) {
            return list;
        }

        list.sort(Comparator.comparingInt(a -> a.start)); // {8, 10},{10, 12},{14, 19}

        List<Interval> response = new LinkedList<>();
        Interval curr = list.get(0); // curr = {8, 10}

        for (int index = 1; index < list.size(); index++) {
            Interval next = list.get(index); // {10, 12}
            if (curr.end >= next.start) { // overlapping is there
                curr.end = Math.max(curr.end, next.end);
            } else {
                response.add(curr);
                curr = next;
            }
        }
        response.add(curr);

        return response;
    }


    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // Sort intervals by start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            if (current[1] >= next[0]) {
                current[1] = Math.max(current[1], next[1]); // merge
            } else {
                merged.add(current);
                current = next;
            }
        }
        merged.add(current); // add the last one

        return merged.toArray(new int[merged.size()][]);
    }


}
