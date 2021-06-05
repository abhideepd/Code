package Recursion_practice;
import java.io.*;
import java.util.*;

// Word Boggle 

public class dummy14 {
    public static void main(String []args)throws IOException
    {
        // char board[][]={{'C','A','P'},{'A','N','D'},{'T','I','E'}};
        // String dictionary[] = {"CAT"};

        // char board[][]={{'G','I','Z'},{'U','E','K'},{'Q','S','E'}};
        // String dictionary[] = {"GEEKS","FOR","QUIZ","GO"};

        char board[][]={{'f','f'},{'d','e'},{'f','b'},{'b','e'}};
        String dictionary[] = {"dfd","ded","fd","e", "dec", "df"};
        // String dictionary[] = {"ded", "df"};

        String answer[]=new dummy14().wordBoggle(board, dictionary);
        for(String i:answer)
        System.out.print(i+" ");
    }
    public String[] wordBoggle(char board[][], String[] dictionary)
    {
        // Write your code here
        ArrayList<String> ans=new ArrayList<String>();
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[0].length; j++)
            {
                for(int k=0; k<dictionary.length; k++)
                {
                    if(dictionary[k].charAt(0)=='0')
                    continue;
                    if(dictionary[k].charAt(0)==board[i][j])
                    {
                        if(function(board, dictionary[k], 0, i, j))
                        {
                            ans.add(dictionary[k]);
                            dictionary[k]="0";
                        }
                    }
                }
            }
        }
        String answer[]=new String[ans.size()];
        for(int i=0; i<ans.size(); i++)
        {
            answer[i]=ans.get(i);
        }
        return answer;
    }
    static boolean function(char board[][], String s, int index, int x, int y)
    {
        if(x<0)return false;
        if(y<0)return false;
        if(x>=board[0].length)return false;
        if(y>=board.length)return false;

        if(index==s.length())return true;
        if(board[x][y]!=s.charAt(index))return false;

        board[x][y]='0';
        return function(board, s, index+1, x+1, y+1)||function(board, s, index+1, x+1, y-1)||function(board, s, index+1, x-1, y+1)||function(board, s, index+1, x-1, y-1)||function(board, s, index+1, x, y+1)||function(board, s, index+1, x, y-1)||function(board, s, index+1, x+1, y)||function(board, s, index+1, x-1, y);
    }
}
