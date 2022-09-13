package com.Sundeep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class merge_intervals {
    public int[][] merges(int[][] intervals) {
        if(intervals.length <= 1)
            return intervals;
        List<int[]> res =new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] current_interval = intervals[0];
        res.add(current_interval);
        for(int[] i : intervals){
            int current_begin = current_interval[0];
            int current_end = current_interval[1];
            int next_begin = i[0];
            int next_end = i[1];
            if(current_end >= next_begin){
                current_interval[1] = Math.max(current_end,next_end);
            }
            else {
                current_interval = i;
                res.add(current_interval);
            }
        }
        return res.toArray(new int[res.size()][res.size()]);
    }
}
