package Recursion_practice;
import java.io.*;
import java.util.*;
public class prob30 {
    public static void main(String args[])
    {
        // int n=40321;
        //  int n=5040;
        // int n=208381;
         int n=236290168;
        ArrayList<Integer> ans=(new YXXYSolution().FactDigit(n));
        String temp="";
        for(int i:ans)
            temp=temp+i;
        System.out.println(temp);
        String compare="18";
        System.out.println(temp.equalsIgnoreCase(compare));
    }
}
class YXXYSolution
{
    ArrayList<Integer> FactDigit(int N)
    {
        ArrayList<Integer> ans=new ArrayList<Integer>();
        int diff=0;
        int prod=1, counter=0;
        while((++counter<10)&&(prod*counter<=N))
        {
            prod=prod*counter;
            diff=N-prod;
        }
        if(diff!=0)
            ans=FactDigit(diff);
        ans.add(--counter);
        return ans;
    }
}