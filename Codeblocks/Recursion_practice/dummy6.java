package Recursion_practice;
import java.io.*;
import java.util.*;
public class dummy6 {
    public static void main(String []args)throws IOException
    {
        // print(1);
        // print(2);
        print(3);
    } 
    static void print(int n)
    {
        List<String> s=new dummy6().AllParenthesis(n);
        for(String i:s)
        System.out.println(i);
    }   

    //  START
    static List<String> answer;
    public List<String> AllParenthesis(int n) 
    {
        answer=new ArrayList<String>();
        function("", n*2, 0, 0);
        return answer;
    }
    static void function(String str, int n, int open, int close)
    {
        if((close>open)||(open>n/2)) 
        {
            return;
        }
        
        if((open+close==n)&&(open==close))
        {
            answer.add(str);
            return;
        }

        function(str+"(", n, open+1, close);
        function(str+")", n, open, close+1);
    }
    //  END
}
