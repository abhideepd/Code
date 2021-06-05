package Recursion_practice;
import java.io.*;
import java.util.*;
public class prob21 {
    public static void main(String []args)throws IOException
    {
        // int arr[]={2, 1, 3};
        int arr[]={10};
        double y1=0.0, ans=0.0;
        for(int i=0; i<arr.length; i++)
        {
            double y2=arr[i];
            ans=ans+AUV(y1, y2);
            System.out.println(i+": "+ans);
            y1=y2;
        }
        ans=ans+AUV(arr[arr.length-1], 0);
        String a=Long.toString((long)ans);
        System.out.println((int)ans);
    }
    static double AUV(double y1, double y2)
    {
        double delta_x=1.0;
        double delta_y=Math.abs(y2-y1);
        double ans=0.5*delta_x*delta_y;
        System.out.println(ans);
        ans=ans+Math.min(y1, y2);
        return ans;
    }
}
