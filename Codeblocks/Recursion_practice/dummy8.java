package Recursion_practice;
import java.io.*;
import java.util.*;
public class dummy8 {
    public static void main(String args[])throws IOException
    {
        // char board[][]={{'a','g','b','c'},{'q','e','e','l'},{'g','b','k','s'}};
        // String word="geeks";
        // System.out.println(new dummy8().isWordExist(board, word));

        // char board[][]={{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}};
        // String word="sabfs";
        // System.out.println(new dummy8().isWordExist(board, word));

        // char board[][]={{'a','b','c','d', 'e', 'f'},{'a','b','c','d', 'e', 'f'},{'a','b','c','d', 'e', 'f'},{'a','b','c','d', 'e', 'f'},{'a','b','c','d', 'e', 'f'},{'a','b','c','d', 'e', 'f'},{'a','b','c','d', 'e', 'f'}};
        // String word="bbbcd";
        // System.out.println(new dummy8().isWordExist(board, word));

        // char board[][]={{'a','b','c','d', 'e', 'f'},{'a','b','c','d', 'e', 'f'},{'a','b','c','d', 'e', 'f'},{'a','b','c','d', 'e', 'f'},{'a','b','c','d', 'e', 'f'},{'a','b','c','d', 'e', 'f'},{'a','b','c','d', 'e', 'f'}};
        // String word="deeedccdeff";
        // System.out.println(new dummy8().isWordExist(board, word));
        
        // char board[][]={{'a','b','c','d'},{'f','s','k','e'},{'g','h','e','e'},{'i','j','k','g'}};
        // String word="geeks";
        // System.out.println(new dummy8().isWordExist(board, word));

        // char board[][]={{'a','b','c','d'},{'f','s','k','e'},{'g','h','e','e'},{'i','j','k','g'}};
        // String word="abcdeegh";
        // System.out.println(new dummy8().isWordExist(board, word));
    }

    //  START

    public boolean isWordExist(char[][] board, String word)
    {
        // Code here
        return function(board, word, 0, 0, 0);
    }
    boolean function(char[][] board, String word, int row, int col, int word_index)
    {
        if(word_index==word.length())
        return true;

        if(row>=board.length)
        return false;

        if(col>=board[0].length)
        return false;

        if(row<0)
        return false;

        if(col<0)
        return false;

        if(board[row][col]==word.charAt(word_index))
        {
            char temp=board[row][col];
            board[row][col]='1';
            if((function(board, word, row+1, col, word_index+1)||function(board, word, row-1, col, word_index+1)||function(board, word, row, col+1, word_index+1)||function(board, word, row, col-1, word_index+1)))
            return true;
            else
            board[row][col]=temp;
        }

        if(word_index==0)
        {
            if(col+1<board[0].length)
            return function(board, word, row, col+1, word_index);
            else if(row+1<board.length)
            return function(board, word, row+1, 0, word_index);
            else
            return false;
        }

        return false;
    }

    //  END
}
