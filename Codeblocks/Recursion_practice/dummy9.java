package Recursion_practice;
import java.io.*;
import java.util.*;
public class dummy9 {
    public static void main(String []args)throws IOException
    {
        // int arr[]={7,2,6,5};
        // print(arr, 16);

        // int arr[]={7,6,5};
        // print(arr, 16);

        int arr[]={6,5,7,1,8,2,9,9,7,7,9};
        print(arr, 6);

        // int arr[]={8, 1, 8, 6, 8};
        // print(arr, 12);
    }
    static void print(int []arr, int B)
    {
        ArrayList<Integer> input=new ArrayList<Integer>();

        for(int i:arr)
        input.add(i);

        ArrayList<ArrayList<Integer>> answer=combinationSum(input, B);

        for(ArrayList<Integer> i:answer)
        System.out.println(i);
    }

    //  START

    static ArrayList<ArrayList<Integer>> answer;
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        // add your code here
        answer=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> ans=new ArrayList<Integer>();
        Collections.sort(A);
        function(A, B, ans, 0);
        return answer;
    }
    static void function(ArrayList<Integer> arr, int sum, ArrayList<Integer> ans, int i)
    {
        if(sum==0)
        {
            ans.add(arr.get(i));
            answer.add(ans);
            return;
        }

        if(sum<0)
        {
            return;
        }

        ArrayList<Integer> temp_ans=new ArrayList<Integer>(ans);
        int prev=-1;
        for(int j=i; j<arr.size(); j++)
        {
            if(prev!=arr.get(j))
            {
                int temp=arr.get(j);
                temp_ans.add(temp);
                function(arr, sum-temp, temp_ans, j);
                temp_ans.remove(temp_ans.size()-1);
                prev=arr.get(j);
            }
        }
    }

    //  END
}
