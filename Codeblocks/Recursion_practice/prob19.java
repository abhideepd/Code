package Recursion_practice;
import java.io.*;
import java.util.*;
public class prob19 {
    public static void main(String []args)throws IOException
    {
        // nearest smallest left
        // int arr[]={6, 5, 8, 4, 7, 10, 9};
        int arr[]={4, 3, 7, 5, 6, 4, 2};
        // int arr[]={3, 2, 5, 4};
        int arr1[]=new int[arr.length];
        Stack<Integer> s=new Stack<Integer>();
        arr1[0]=0;
        s.push(0);
        int ans=0;
        for(int i=1; i<arr.length; i++)
        {
            while((s.size()!=0)&&(arr[s.peek()]>arr[i]))
            {
                s.pop();
            }
            if(s.size()!=0)
            if(arr[s.peek()]==arr[i])
            {
                s.pop();
            }
            if(s.size()!=0)
            arr1[i]=s.peek();
            else
            arr1[i]=i;
            s.push(i);
        }
        for(int i=0; i<arr1.length; i++)
        {
            ans=Math.max(ans, i-arr1[i]);
        }
        for(int i:arr)
        System.out.print(i+" ");
        System.out.println();
        for(int i:arr1)
        System.out.print(arr[i]+" ");
        System.out.println();
        for(int i:arr1)
        System.out.print(i+" ");
        System.out.println("\n"+(ans));
    }
}

