package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hydra on 2016/11/13.
 */

public class FindRightInterval {


    public int[] findRightInterval(Interval[] intervals) {


        int[][] startMapIndex = new int[intervals.length][2];

        for (int i = 0; i < intervals.length; ++i) {
            startMapIndex[i][0] = intervals[i].start;
            startMapIndex[i][1] = i;
        }

        Arrays.sort(startMapIndex, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return Integer.compare(ints[0], t1[0]);
            }
        });

        int[] returnValue = new int[intervals.length];


        for (int i = 0; i < intervals.length; ++i) {
            returnValue[i] = findIndexFromInterval(intervals[i].end, startMapIndex);
        }

        return returnValue;
    }

    private int findIndexFromInterval(Integer endPoint, int[][] startMapIndex) {

        for (int i = 0; i < startMapIndex.length; ++i) {
            if (startMapIndex[i][0] >= endPoint) {
                return startMapIndex[i][1];
            }
        }

        return -1;
    }

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        public Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
