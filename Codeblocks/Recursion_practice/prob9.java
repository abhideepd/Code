package Recursion_practice;
import java.io.*;
import java.util.*;
public class prob9 {
 public static void main(String []args)throws IOException
 {
     //int arr[]={2,3};
     //int arr[]={5,2,1};
     int arr[]={2, 5, 8, 11, 13};
     ArrayList<Integer> answer=input(arr);
     System.out.println(answer);
 }   
 static ArrayList<Integer> input(int []arr)
 {
     ArrayList<Integer> a=new ArrayList<Integer>();
     for(int i : arr)
        a.add(i);
    ArrayList<Integer> answer=new Solution5().subsetSums(a, a.size());
    return answer;
 }
}
class Solution5{
    static ArrayList<Integer> answer=new ArrayList<Integer>();
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        answer=new ArrayList<Integer>();
        function1(arr, 0, 0, true);
        Collections.sort(answer);
        return answer;
    }
    static void function1(ArrayList<Integer> arr, int sum, int index, boolean adder)
    {
        if(adder==true)
        answer.add(sum);
        if(index<arr.size())
        {
            function1(arr, sum+arr.get(index), index+1, true);
            function1(arr, sum, index+1, false);
        }
    }
}