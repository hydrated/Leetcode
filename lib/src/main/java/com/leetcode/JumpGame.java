package com.leetcode;

/**
 * Created by hydra on 2016/11/23.
 */

public class JumpGame {
    public boolean canJump(int[] nums) {
        int end = nums.length;
        int[] positions = new int[end];
        int currentIndex = 0;
        int maxJump = 0;
        while(maxJump < end) {
            if(maxJump < nums[currentIndex] + currentIndex) {
                maxJump = nums[currentIndex];
                currentIndex = maxJump;
            }
            if(currentIndex >= end ) return true;
            positions[currentIndex] = 1;
            if(nums[currentIndex] + currentIndex <= maxJump) {
                while(positions[currentIndex] == 1 && currentIndex > 0) {
                    currentIndex--;
                }
                if(currentIndex == 0) {
                    return false;
                }
            }
        }

        return maxJump+1 >= end;
    }


}
