import java.util.*;

/***
 * Given a collection of intervals, merge all overlapping intervals
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[][] {};
        }

        // Sort intervals by start time
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        List<int[]> merged = new ArrayList<>();
        int lastStart = intervals[0][0];
        int lastEnd = intervals[0][1];

        // Check each interval for overlap and add to queue
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            // If there's overlap, update lastEnd
            if (start >= lastStart && start <= lastEnd) {
                lastEnd = Math.max(lastEnd, end);
            } else {
                merged.add(new int[] {lastStart, lastEnd});
                lastStart = start;
                lastEnd = end;
            }
        }
        merged.add(new int[] {lastStart, lastEnd});

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] input = {
            {1,3},
            {2,6},
            {8,10},
            {15,18}
        };
        for (int[] interval : s.merge(input)) {
            System.out.println(Arrays.toString(interval));
        }
    }
}