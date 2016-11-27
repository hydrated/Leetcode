package com.leetcode;

/**
 * Created by hydra on 2016/11/27.
 */

public class RotateArray {
    public void rotate(int[] nums, int k) {

        int length = nums.length;

        int[] returnArray = new int[length];

        int rotatePosition = k % length;
        if(rotatePosition < 0) rotatePosition += length;

        for(int i = 0 ; i < nums.length ; ++i) {
            returnArray[(i+rotatePosition) % length] = nums[i];
        }

        System.arraycopy(returnArray, 0 , nums, 0 , length);
    }
}
