package Recursion_practice;
// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

public class prob10
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solutionx ob = new Solutionx();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}
// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solutionx{
   static ArrayList<Integer> rrr=new ArrayList<Integer>();
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        
        function1(arr, 0, 0, true);
        Collections.sort(rrr);
        return rrr;
    }
    static void function1(ArrayList<Integer> arr, int sum, int index, boolean adder)
    {
        if(adder==true)
        rrr.add(sum);
        if(index<arr.size())
        {
            function1(arr, sum+arr.get(index), index+1, true);
            function1(arr, sum, index+1, false);
        }
    }
}