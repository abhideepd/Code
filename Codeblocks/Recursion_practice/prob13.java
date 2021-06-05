package Recursion_practice;
import java.util.*;
public class prob13 {
    public static void main(String []args)
    {
        // long arr[]={1,2};
        // long arr[]={1,2,3,4};
        // long arr[]={1,2,3,4,5,6,7,8};
        // long arr[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        long arr[]={1,2,3,4,5,6};
        new SolutionX().shuffleArray(arr, arr.length);
        for(long i:arr)
        System.out.print(i+" ");
        System.out.println();
    }
}
class  SolutionX
{
    void shuffleArray(long arr[], int n)
    {
        // Your code goes here
        safal(arr, 0, n-1);
    }
    void safal(long arr[], int start, int end)
    {
        if(end-start+1<=2)
        {
            //System.out.println(start+" "+end);
            return;
        }

        safal(arr, start, ((start+end+1)/2)-1);
        safal(arr, ((start+end+1)/2), end);
        //System.out.println("start: "+" end: "+((start+end+1)/2));
        merge(arr, start, ((start+end+1)/2), (end-start+1)/2);
        // print(arr);
    }
    void print(long []arr)
    {
        for(long i:arr)
        System.out.print(i+" ");
        System.out.println();
    }
    void merge(long arr[], int firsthalf_start, int secondhalf_start, int limit)
    {
        //System.out.println("Limit: "+limit);
        ++firsthalf_start;
        for(int i=1; i<=limit/2; i++)
        {
            //System.out.println("firsthalf_start: "+firsthalf_start+" secondhalf_start: "+secondhalf_start+" Limit: "+limit);
            swap(arr, firsthalf_start, secondhalf_start);
            secondhalf_start+=2;
            firsthalf_start+=2;
        }
    }
    void swap(long arr[], int a, int b)
    {
        //System.out.println(a+" "+b);
        long temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
