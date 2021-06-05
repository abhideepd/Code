package Recursion_practice;
import java.io.*;
import java.util.*;

// Unique Subsets 

public class dummy13 {
    public static void main(String args[])throws IOException
    {
        // int arr[]={2,1,2};
        // int N=3;
        // print(arr, N);

        // int arr[]={1,2,3,3};
        // int N=4;
        // print(arr, N);  
        
        int arr[]={1,2,3,3,4,4,4,4,5,5,6};
        int N=11;
        print(arr, N);  
    }
    static void print(int []arr, int N)
    {
        ArrayList<ArrayList<Integer>> answer=AllSubsets(arr, N);
        // for(ArrayList<Integer> i:answer)System.out.println(i);
    }

    //  START

    // static ArrayList<ArrayList<Integer>> answer; 
    public static ArrayList <ArrayList <Integer>> AllSubsets(int arr[], int n)
    {
        // your code here
        Arrays.sort(arr);
        ArrayList<Integer> temp=new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> answer=new ArrayList<ArrayList<Integer>>();
        function(arr, 0, temp, answer);
        System.out.println("\nAnswer: "+answer);
        return answer;
    }
    static void function(int []arr, int index, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> answer)
    {
        answer.add(temp);
        // System.out.println(temp+" --- "+answer);
        System.out.println(temp);
        int pre=-1;  
        for(int i=index; i<arr.length; i++)
        {
            if(pre!=arr[i])
            {
                temp.add(arr[i]);
                function(arr, i+1, temp, answer);
                temp.remove(temp.size()-1);
                pre=arr[i];
            }
        }
    }

    //  END
}

