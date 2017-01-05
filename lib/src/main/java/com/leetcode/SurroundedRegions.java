package com.leetcode;

import java.util.Stack;

/**
 * Created by hydra on 2017/1/2.
 */

public class SurroundedRegions {

    private int width;
    private int height;

    Stack<Integer> xStack = new Stack<>();
    Stack<Integer> yStack = new Stack<>();

    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0) return;

        width = board[0].length;
        height = board.length;


        for(int i = 0 ; i < width ; ++i) {
            if(board[i][0] == 'O') {
                xStack.push(i);
                yStack.push(0);
            }
            if(board[i][height-1] == '0') {
                xStack.push(i);
                yStack.push(height-1);
            }
        }
        for(int j = 0 ; j < height ; ++j) {
            if(board[0][j] == 'O') {
                xStack.push(0);
                yStack.push(j);
            }
            if(board[width-1][j] == '0') {
                xStack.push(width-1);
                yStack.push(j);
            }
        }

        while (!xStack.isEmpty()) {
            int x = xStack.pop();
            int y = xStack.pop();
            markFourDirections(x,y,board);
        }

        for(int i = 0 ; i < width ; ++i) {
            for (int j = 0 ; j < height ; ++j) {
                if(board[i][j] == 'Y') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void markFourDirections(int x, int y, char[][] board) {
        if(x < 0 || x >= width || y < 0 || y >= height) return;
        if(board[x][y] == 'X' || board[x][y] == 'Y') return;

        board[x][y] = 'Y';
        xStack.push(x-1);
        yStack.push(y);
        xStack.push(x+1);
        yStack.push(y);
        xStack.push(x);
        yStack.push(y-1);
        xStack.push(x);
        yStack.push(y+1);
    }
}
