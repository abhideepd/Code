package Recursion_practice;
import java.io.*;
import java.util.*;
public class prob2 {
    public static void main(String []args)throws IOException{
        String str = "abcd";
        prob2 obj1=new prob2();
        ArrayList<String> answer = obj1.spaceString(str);
        System.out.println(answer);
    }
    ArrayList<String> spaceString(String str)
    {
        // Your code here
        ArrayList<String> x=new ArrayList<String>();
        func(str, 0, "", x);
        return x;
    }
    static void func(String s, int i, String ans, ArrayList<String> x)
    {
        if(i==s.length())
        {
            //System.out.println(ans);
            x.add(ans);
            return;
        }
        func(s, i+1, ans+s.charAt(i), x);
        if(i+1<s.length())
            func(s, i+1, ans+s.charAt(i)+" ", x);
    }
}
