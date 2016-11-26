package com.leetcode;

import java.util.Arrays;

/**
 * Created by hydra on 2016/11/26.
 */

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int b = 0;

        for(int i = 0 ; i < nums.length ; ++i) {
            if(nums[i] != val) {
                nums[b] = nums[i];
                b++;
            }
        }
        return b;
    }
}
