package Recursion_practice;
import java.io.*;
import java.util.*;
public class prob27 {
    public static void main(String []args)
    {
        String a="a";
        // String a="ab";
        // String a="abc";
        // String a="absg";
        System.out.println(new YYYSolution().permutation(a));
    }
}
class YYYSolution
{
    public ArrayList<String> permutation(String S)
    {
        ArrayList<String> ans=new ArrayList<String>();
        if(S.length()==1)
        {
            ans.add(S);
            return ans;
        }
        for(int i=0; i<S.length(); i++)
        {
            String temp=S.substring(0, i)+S.substring(i+1, S.length()); 
            for(String temp3 : permutation(temp))
            {
                ans.add(S.charAt(i)+temp3);
            }
        }
        Collections.sort(ans);
        return ans;
    }	   
}