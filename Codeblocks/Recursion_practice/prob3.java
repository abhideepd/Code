package Recursion_practice;
import java.io.*;
import java.util.*;
public class prob3 {
    public static void main(String []args)throws IOException
    {
        prob3 obj=new prob3();
        ArrayList<Integer> arr=new ArrayList<Integer>();
        String input = "[2, 3]";
        input_arr(arr, input);
        int N=arr.size();
        System.out.println(arr+" "+N);
        ArrayList<Integer> answer = obj.subsetSums(arr, N);
        System.out.println(answer);
    }    
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> ans=new ArrayList<Integer>();
        return ans;
    }
    static void input_arr(ArrayList<Integer> arr, String inp)
    {
        inp = inp.replace('[', ' ');
        inp = inp.replace(']', ' ');
        inp.trim();
        String inp_arr[] = inp.split(",");
        for(String i:inp_arr){
            int temp=Integer.parseInt(i.trim());
            arr.add(temp);
        }
    }
}