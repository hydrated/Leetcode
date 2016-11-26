package com.leetcode;

/**
 * Created by hydra on 2016/11/26.
 */

public class UniquePathII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length ==0) return 0;

        int height = obstacleGrid.length;
        int width = obstacleGrid[0].length;

        for(int i = 0 ; i < height ; ++i) {
            for (int j = 0 ; j < width; ++j) {
                if(obstacleGrid[i][j] == 1) obstacleGrid[i][j] = -1;
            }
        }

        obstacleGrid[0][0] = 1;

        for(int i = 1; i < height ; ++i) {
            if(obstacleGrid[i][0] == -1) {
                obstacleGrid[i][0] = 0 ;
            } else {
                obstacleGrid[i][0] = obstacleGrid[i-1][0];
            }
        }

        for(int j = 1 ; j < width ; ++j) {
            if(obstacleGrid[0][j] == -1) {
                obstacleGrid[0][j] = 0;
            } else {
                obstacleGrid[0][j] = obstacleGrid[0][j-1];
            }
        }


        for(int i = 1 ; i < height ; ++i) {
            for(int j = 1 ; j < width ; ++j) {
                obstacleGrid[i][j] = obstacleGrid[i][j] == -1 ? 0 : obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
            }
        }

        return obstacleGrid[height-1][width-1];

    }
}
