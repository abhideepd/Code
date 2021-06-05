package Recursion_practice;
import java.io.*;
import java.util.*;
public class prob23 {
    public static void main(String args[])
    {
        // String a="a";
        // String a="ab";
        // String a="abc";
        String a="abcd";
        System.out.println(new GfGx().spaceString(a));
    }
}
class GfGx
{
    ArrayList<String> spaceString(String str)
    {
        // Your code here
        ArrayList<String> temp=new ArrayList<String>();
        temp.add(str);
        for(int i=str.length()-1; i>0; i--)
        {
            String temp2="";
            if(str.charAt(i-1)!=' ')
            {
                temp2=str.substring(0, i)+" "+str.substring(i, str.length());
            }
            else
            {
                break;
            }
            ArrayList<String> temp3=spaceString(temp2);
            // temp.add(temp2);
            temp.addAll(temp3);
        }
        return temp;
    }
}
