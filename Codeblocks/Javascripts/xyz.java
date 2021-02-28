package Javascripts;

import java.io.*;
import java.util.*;

public class xyz {
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader x = new BufferedReader(new InputStreamReader(System.in));
        // int input=Integer.parseInt(x.readLine());

        int input = 4;

        n_queen(input);
    }

    static void n_queen(int n) {

        // return false if board size is less than 4
        int board[][] = new int[n][n];
        populate(board, 0, 0);
    }

    static boolean isSafe(int[][] board, int x, int y) {
        int x1, y1;

        // left diognal
        x1 = x;
        y1 = y;
        while ((x1 >= 0) && (y1 >= 0) && (x1 < board.length) && (y1 < board.length)) {
            if (board[x1][y1] == 1)
                return false;

            --x1;
            --y1;
        }

        // right diognal
        x1 = x;
        y1 = y;
        while ((x1 >= 0) && (y1 >= 0) && (x1 < board.length) && (y1 < board.length)) {
            if (board[x1][y1] == 1)
                return false;

            ++x1;
            --y1;
        }

        // up
        x1 = x;
        y1 = y;
        while ((x1 >= 0) && (y1 >= 0) && (x1 < board.length) && (y1 < board.length)) {
            if (board[x1][y1] == 1)
                return false;

            --y1;
        }

        return true;
    }

    static boolean populate(int[][] board, int x, int y) {

        if (y == board.length)
            return true;

        for (int i = x; i < board.length; i++) {
            if (populate(board, i, y)) {
                if (isSafe(board, i, y + 1)) {
                    board[i][y] = 1;
                }
            }
        }

        return true;
    }
}