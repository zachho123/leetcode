/*
https://leetcode.com/problems/merge-intervals/

Given a collection of intervals, merge all overlapping intervals.
*/
import java.util.*;

public class Solution {

    public int[][] merge(int[][] intervals) {
        return first(intervals);
    }

    private int[][] first(int[][] intervals) {
        int[][] output = null;
        ArrayList<Integer> mergedIntervals = new ArrayList<>();

        // check for valid input
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }

        // sort input by lower bounds
        Collections.sort(Arrays.asList(intervals),
            new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    return a[0] - b[0];
                }
            }
        );

        // take first lower and upper bound
        int lowerBound = intervals[0][0];
        int upperBound = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            // overlap on either side or one interval contained within the other
            if (intervals[i][0] >= lowerBound && intervals[i][0] <= upperBound
                    || intervals[i][1] >= lowerBound && intervals[i][1] <= upperBound) {
                lowerBound = Math.min(lowerBound, intervals[i][0]);
                upperBound = Math.max(upperBound, intervals[i][1]);
            } else { // no overlap
                mergedIntervals.add(lowerBound);
                mergedIntervals.add(upperBound);
                lowerBound = intervals[i][0];
                upperBound = intervals[i][1];
            }
        }
        mergedIntervals.add(lowerBound);
        mergedIntervals.add(upperBound);

        // construct output
        int set = 0;
        output = new int[mergedIntervals.size()/2][2];
        for (int i = 0; i < mergedIntervals.size(); i+=2) {
            output[set][0] = mergedIntervals.get(i);
            output[set][1] = mergedIntervals.get(i+1);
            set++;
        }

        return output;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // expected output [[1,6], [8,10], [15,18]]
        int[][] input1 = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        // expected output [[1,10], [15,18]]
        int[][] input2 = { { 1, 3 }, { 2, 6 }, { 4, 10 }, { 15, 18 } };
        // expected output [[0,4]]
        int[][] input3 = { {1, 4}, {0, 4} };
        // expected output [[1,6], [8,12]]
        int[][] input4 = { { 1, 6 }, { 2, 3 }, { 9, 12 }, { 8, 11 } };
        // expected output [[0,0], [1,4]]
        int[][] input5 = { {1, 4}, {0, 0} };
        // expected output [[0,5]]
        int[][] input6 = { {1, 4}, {0, 5} };
        // expected output [[1,6], [8,10], [15,18]]
        int[][] input7 = { { 1, 3 }, { 8, 10 }, { 15, 18 }, {2, 6} };


        List<int[][]> inputs = new ArrayList<>();
        inputs.add(input1);
        inputs.add(input2);
        inputs.add(input3);
        inputs.add(input4);
        inputs.add(input5);
        inputs.add(input6);
        inputs.add(input7);

        for (int[][] in : inputs) {
            for (int[] arr : sol.merge(in)) {
                System.out.print("[");
                for (int i : arr) {
                    System.out.print(i + ",");
                }
                System.out.print("],");
            }
            System.out.println();
        }
    }
}
