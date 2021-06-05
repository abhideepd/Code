package Recursion_practice;
import java.io.*;
import java.util.*;
public class prob17 {
    public static void main(String []args)throws IOException
    {
        BufferedReader x=new BufferedReader(new InputStreamReader(System.in));
        String input_size[]=x.readLine().split(" ");
        int n=Integer.parseInt(input_size[0]);
        int m=Integer.parseInt(input_size[1]);
        int queries[][]=new int[n][3];
        for(int i=0; i<m; i++)
        {
            String temp[]=x.readLine().split(" ");
            queries[i][0]=Integer.parseInt(temp[0]);
            queries[i][1]=Integer.parseInt(temp[1]);
            queries[i][2]=Integer.parseInt(temp[2]);
        }
        System.out.println(arrayManipulation(n, queries));
    }
    static long arrayManipulation(int n, int[][] queries) {

        long ans=0;
        ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<n; i++)
        {
            int a=queries[i][0];
            int b=queries[i][1];
            int k=queries[i][2];
            push(arr, a, b, k);
        }
        return ans;
    }
    static void push(ArrayList<ArrayList<Integer>> arr, int a, int b, int k)
    {
        
    }
}
