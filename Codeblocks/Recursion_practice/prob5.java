package Recursion_practice;
import java.io.*;
import java.util.*;
public class prob5 
{
    public static void main(String []args)throws IOException
    {
        ArrayList<Integer> arr=new ArrayList<Integer>();
        //input1(arr);
        input2(arr);
        ArrayList<Integer> ans=new Solution1().subsetSums(arr, arr.size());
        System.out.println(ans);
    }
    static void input1(ArrayList<Integer> arr)
    {
        arr.add(2);
        arr.add(3);
    }
    static void input2(ArrayList<Integer> arr)
    {
        arr.add(5);
        arr.add(2);
        arr.add(1);
    }
}
class Solution1
{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N)
    {
        // code here
        ArrayList<Integer> ans=new ArrayList<Integer>();
        subsetsum(arr, ans);
        Collections.sort(ans);
        return ans;
    }
    static void subsetsum(ArrayList<Integer> arr, ArrayList<Integer> ans)
    {
        if(arr.size()==0)
        {
            ans.add(0);
            return;
        }
        int sum=0;
        for(int i=0; i<arr.size(); i++)
        {
            sum=sum+arr.get(i);
            ans.add(sum);
        }
        arr.remove(0);
        subsetsum(arr,ans);
    }
}
