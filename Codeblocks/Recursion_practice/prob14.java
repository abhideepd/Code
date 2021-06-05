package Recursion_practice;
import java.util.*;
public class prob14 {
    public static void main(String []args)
    {
        // long arr[]={1,2};
        // long arr[]={1,2,3,4};
        // long arr[]={1,2,3,4,5,6,7,8};
        // long arr[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        // long arr[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        long arr[]={1,2,3,4,5,6};
        new SolutionXXXX().shuffleArray(arr, arr.length);
        for(long i:arr)
        System.out.print(i+" ");
        System.out.println();
    }
}

class SolutionXXXX
{
    void shuffleArray(long arr[], int n)
    {
        // Your code goes here
        int temp=n-2;
        //System.out.println("CC");
        if(temp==0)
        return;
        int start1=(arr.length-n+2)/2;
        int start2=(arr.length)/2;
        for(int i=0; i<temp/2; i++, start1++, start2++)
        {
            //System.out.println("start1: "+start1+"  start2: "+start2);
            swap(arr, start1, start2);
        }
        
        //print(arr);
        shuffleArray(arr, n-2);
    }
    void print(long []arr)
    {
        for(long a:arr)
        System.out.print(a+" ");
        System.out.println();   
    }
    void swap(long arr[], int a, int b)
    {
        long temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}