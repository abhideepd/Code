package Recursion_practice;
import java.util.*;
public class prob18 {
    public static void main(String []args)
    {
        int A[]={2,1,3};
        double ans = ((A[0] + A[A.length-1]) /2.0);
        System.out.println("ans1: "+ans);
        for(int i=1; i<A.length; i++)
        {
            ans = ans + ( ( Math.max(A[i-1], A[i])-Math.min(A[i-1], A[i]) ) /2.0 ) + Math.min(A[i], A[i-1]);
        }
        System.out.println("ans2: "+ans);
        
        String answer=Long.toString((long)ans);
        System.out.println("answer: "+answer);
    }

}
