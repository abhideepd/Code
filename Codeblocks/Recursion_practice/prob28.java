package Recursion_practice;
import java.io.*;
import java.util.*;
public class prob28 {
    public static void main(String []args)
    {
        // int n=1;
        // int n=3;
        int n=6;
        // int n=2;
        // int n=4;
        System.out.println(new SolutionYX().recamanSequence(n));
    }
}
class SolutionYX{
    static List<Integer> recamanSequence(int n){
        // code here
        List<Integer> ans=new ArrayList<Integer>();
        if(n==0)
        {
            ans.add(0);
            return ans;
        }
        ans=recamanSequence(n-1);
        int temp=ans.get(ans.size()-1)-n;
        if((temp>0)&&(ans.indexOf(temp)==-1))
        {
            ans.add(temp);
        }
        else
        {
            ans.add(temp+2*n);
        }
        return ans;
    }
}