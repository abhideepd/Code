package Recursion_practice;
import java.io.*;
import java.util.*;
public class prob29 {
    public static void main(String []args)
    {
        // int a=5;
        int a=32;
        // int a=12;
        int ans=1;
        for(int i=1; i<=33; i++)
        ans=ans*i;

        System.out.println(new YXYSolution().lastNon0Digit(a)+" "+ans);
    }
}
class YXYSolution{
    
    int lastNon0Digit(int N){
        // Code here
        if(N<=1)
            return 1;
        int temp=lastNon0Digit(N-1);
        temp=temp*N;
        if(temp%10==0)
        temp=temp/10;
        System.out.println(N+": "+temp+" Ans:"+temp%10);
        return temp%10;
    }
    
}