package Recursion_practice;
import java.io.*;
import java.util.*;
public class prob25 {
    public static void main(String []args)
    {
        System.out.println(new XXSolution().jugglerSequence(9));
        System.out.println(new XXSolution().jugglerSequence(6));
    }
}
class XXSolution{
    static List<Integer> jugglerSequence(int N){
        // code here
        if(N==1)
        {
            List<Integer> temp=new ArrayList<Integer>();
            temp.add(1);
            return temp;
        }
        double ans=Math.sqrt(N);
        if(N%2!=0)
            ans=ans*ans*ans;
        List<Integer> temp=jugglerSequence((int)ans);
        List<Integer> temp2=new ArrayList<Integer>();
        temp2.add(N);
        temp2.addAll(temp);
        return temp2;
    }
}