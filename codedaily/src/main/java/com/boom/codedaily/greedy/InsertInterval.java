package com.boom.codedaily.greedy;

import java.util.*;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int i = 0;
        // Identify the position where the new interval will sit.
        while (i < intervals.length && newInterval[0] > intervals[i][1]) {
            list.add(intervals[i++]);
        }

        // i is the index where new intervals has to be inserted
        int j = i;
        // Check upto which index we could merge to the new interval.
        while (j < intervals.length && intervals[j][0] <= newInterval[1]) {
            j++;
        }

        if (j != i) {// Now merge the intervals into one.
            int mergedMin = Math.min(intervals[i][0], newInterval[0]);
            int mergedMax = Math.max(intervals[j - 1][1], newInterval[1]);
            list.add(new int[] { mergedMin, mergedMax });
            i = j;
        } else {// If there are no intervals that could be merged with new interval
                // new Interval can be simply inserted at current point.
            list.add(newInterval);
        }
        // If there are still more intervals left untraversed, add them to result list.
        while (i < intervals.length)
            list.add(intervals[i++]);
        return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {
        InsertInterval in = new InsertInterval();
        int[][] intervals = { { 1, 2 }, { 5, 6 } };
        int[] newInterval = { 3, 4 };
        int[][] res = in.insert(intervals, newInterval);
        for (int[] r : res) {
            System.out.println(r[0] + " " + r[1]);
        }
    }
}