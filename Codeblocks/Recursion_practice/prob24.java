package Recursion_practice;
import java.io.*;
import java.util.*;
public class prob24 {
    public static void main(String args[])
    {
        // long arr[]={1, 2};
        // long arr[]={1, 2, 9, 15};
        // long arr[]={1, 2, 3, 4, 5, 6};
        // long arr[]={1, 2, 3, 4, 5, 6, 7, 8};
        long arr[]={1,2,3,4,5,6,7,8,9,10};
        new YSolution().shuffleArray(arr, arr.length);
        for(long i:arr)
            System.out.print(i+" ");
    }
}

class  YSolution
{
    void shuffleArray(long arr[], int n)
    {
        // Your code goes here

        if(n<4)
        return;
        int diff=arr.length-n;
        int start=(arr.length/2)-(diff/2)-1;
        int end=(arr.length/2)+(diff/2);
        // System.out.println("n: "+n+" start:"+start+" end:"+end+" diff:"+diff);
        for(int i=start; i<=end; i+=2)
        {
            long temp=arr[i];
            arr[i]=arr[i+1];
            arr[i+1]=temp;
        }
        shuffleArray(arr, n-2);
    }
}
