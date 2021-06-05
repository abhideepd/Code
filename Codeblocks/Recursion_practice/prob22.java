package Recursion_practice;
import java.io.*;
import java.util.*;
public class prob22 {
    public static void main(String []args)throws IOException
    {
        // int n=1;
        // int n=2;
        int n=3;
        //int n=4;
        System.out.println(new XSolution().graycode(n));
    }
}
class XSolution
{
    public ArrayList<String> graycode(int n)
    {
        //code here
        if(n==1)
        {
            ArrayList<String> temp=new ArrayList<String>();
            temp.add("0");
            temp.add("1");
            return temp;
        } 
        ArrayList<String> temp=graycode(n-1);
        ArrayList<String> temp2=new ArrayList<String>();
        String a="0", b="1", c="";
        while(temp.size()!=0)
        {
            String temp3=temp.remove(0);
            temp2.add(temp3+a);
            temp2.add(temp3+b);
            c=a;
            a=b;
            b=c;
        }
        return temp2;
    }
}