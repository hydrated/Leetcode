package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by hydra on 2016/11/26.
 */

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> returnSet = new ArrayList<>();

        returnSet.add(new ArrayList<Integer>());

        for(int i = 0 ; i < nums.length ; ++i) {
            List<List<Integer>> tempContainer = new ArrayList<>();
            for(List<Integer> list : returnSet) {
                appendToCurrentArray(tempContainer,(ArrayList)list, nums[i]);
            }
            returnSet.addAll(tempContainer);
        }

        return returnSet;
    }

    private void  appendToCurrentArray(List<List<Integer>> container, ArrayList<Integer> list, int value) {
        ArrayList<Integer> copylist = (ArrayList)list.clone();
        copylist.add(value);
        container.add(copylist);
    }
}
