package Recursion_practice;
import java.io.*;
import java.util.*;

// Subsets

public class dummy15 {
    public static void main(String args[])throws IOException
    {
        ArrayList<Integer> arr1=new ArrayList<Integer>();
        int []arr={1, 2, 3};
        // int []arr={1, 2};

        for(int i:arr)
        arr1.add(i);

        ArrayList<ArrayList<Integer>> ans=subsets(arr1);
        // for(ArrayList<Integer> i:answer)
        // System.out.println(i);
    }

    //  START

    static ArrayList<ArrayList<Integer>> answer;
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A)
    {
        //code here
        answer=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp=new ArrayList<Integer>();
        function(A, temp, 0);
        System.out.println("\nAnswer: "+answer);
        return answer;
    }
    public static void function(ArrayList<Integer> A, ArrayList<Integer> temp, int index)
    {
        // answer.add(temp);
        System.out.println(temp+" ---- "+answer);

        // ArrayList<Integer> temp_temp=new ArrayList<Integer>(temp);
        for(int i=index; i<A.size(); i++)
        {
            temp.add(A.get(i));
            answer.add(temp);
            function(A, temp, i+1);
            temp.remove(temp.size()-1);
        }
    }

    // END
}
