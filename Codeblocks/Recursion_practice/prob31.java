package Recursion_practice;
import java.io.*;
import java.util.*;
public class prob31 {
    public static void main(String args[])
    {
        int N=8;
        long ans=new SolutionCXZ().sequence(N);
        System.out.println(ans);
        long compare=1226103906007L;
        System.out.println(ans==compare);
    }
}


class SolutionCXZ{
    static long sequence(int N){
        // code here
        if(N==1)
        return 1;
        int start=(N-1)*N/2+1;
        int end=start+N-1;
        long prod=1;
        //System.out.println(start+" "+end);
        for(long i=start; i<=end; i++)
        {
            prod=prod*i;
        }
        return prod+sequence(N-1);
    }
}