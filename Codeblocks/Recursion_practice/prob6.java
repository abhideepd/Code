package Recursion_practice;
import java.io.*;
import java.util.*;
public class prob6 {
    public static void main(String []args)throws IOException
    {
        long arr[] = {1, 2, 9, 15};
        //long arr[] = {1, 2, 3, 4, 5, 6};
        new Solution2().shuffleArray(arr, arr.length);
    }
}
class  Solution2
{
    void shuffleArray(long arr[], int n)
    {
        // Your code goes here
        if(n>=(arr.length/2)+arr.length)
        return;
        System.out.print(arr[n-arr.length]+" "+arr[((arr.length/2)+(n-arr.length))]+" ");
        shuffleArray(arr, n+1);
    }
}