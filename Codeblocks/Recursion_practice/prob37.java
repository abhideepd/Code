package Recursion_practice;
import java.io.*;
import java.util.*;
public class prob37 {
    public static void main(String []args)
    {
        long n=15;
        System.out.println(nthPosition(n));
    }
    static long nthPosition(long n){
        // code here
        System.out.println(n);
        if(n==1)
            return 1;
        return 2*nthPosition(n>>1);
    }
}
 