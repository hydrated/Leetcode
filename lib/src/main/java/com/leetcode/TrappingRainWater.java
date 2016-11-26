package com.leetcode;

import java.util.ArrayList;

/**
 * Created by hydra on 2016/11/26.
 */

public class TrappingRainWater {
    public int trap(int[] height) {

        ArrayList<Integer> heightPivots = new ArrayList<>();

        for(int i = 0 ; i < height.length ; ++i) {
            if(i+1 < height.length && height[i+1] < height[i]) {
                heightPivots.add(i);
            }
        }

        if(height.length != 0 && height[height.length-1] > 0) {
            heightPivots.add(height.length-1);
        }

        removeContinueNumbers(heightPivots);
        removePivotsThatUseless(height, heightPivots);

        int sum = 0;

        for(int i = 0 ; i < heightPivots.size() ; ++i) {
            if(i != heightPivots.size()-1) {
                sum += sumTrappedWaterFromRange(height, heightPivots.get(i), heightPivots.get(i + 1));
            }
        }


        return sum;
    }

    private void removeContinueNumbers(ArrayList<Integer> heightPivots) {
        ArrayList<Integer> tempPivots = new ArrayList<>();
        for(int integer : heightPivots) {
            if(heightPivots.contains(integer+1)){
                tempPivots.add(integer+1);
            }
        }

        heightPivots.removeAll(tempPivots);
    }

    private void removePivotsThatUseless(int[] height, ArrayList<Integer> heightPivots) {
        ArrayList<Integer> tempPivots = new ArrayList<>();
        for(int i = 0 ; i < heightPivots.size() ; ++i) {
            if(hasLeftMaximum(height, heightPivots,i) && hasRightMaximum(height,heightPivots, i)) {
                tempPivots.add(heightPivots.get(i));
            }
        }
        heightPivots.removeAll(tempPivots);
    }

    private boolean hasLeftMaximum(int[] height, ArrayList<Integer> heightPivots, int index) {
        for(int i = 0 ; i < index ; ++i) {
            if(height[heightPivots.get(i)] > height[heightPivots.get(index)]) return true;
        }
        return false;
    }

    private boolean hasRightMaximum(int[] height, ArrayList<Integer> heightPivots, int index) {
        for(int i = index ; i < heightPivots.size() ; ++i) {
            if(height[heightPivots.get(index)] < height[heightPivots.get(i)]) return true;
        }
        return false;
    }


    private int sumTrappedWaterFromRange(int[] height, int startIndex, int endIndex) {

        int length = endIndex - startIndex -1;
        int smallerNumber = height[startIndex] > height[endIndex] ? height[endIndex] : height[startIndex];

        int sum = smallerNumber * length ;

        for(int i = startIndex + 1 ; i < endIndex ; ++i) {
            sum -= height[i] > smallerNumber ? smallerNumber : height[i];
        }

        return sum;
    }
}
