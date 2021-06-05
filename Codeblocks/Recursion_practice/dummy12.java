package Recursion_practice;
import java.io.*;
import java.util.*;

// Largest number in K swaps 

public class dummy12 {
    public static void main(String []args)throws IOException
    {
        // System.out.println(findMaximumNum("1234567", 4));
        // System.out.println(findMaximumNum("3435335", 3));
        System.out.println(findMaximumNum("4551711527", 3));
        System.out.println(findMaximumNum("61892795431", 3));
        // System.out.println(findMaximumNum("3435335", 30));
    }

    //  START

    public static String findMaximumNum(String str, int k)
    {
        //code here.
        char s[]=str.toCharArray();
        return function(s, k, 0);
    }
    static String function(char[] str, int k, int index)
    {
        if((index==str.length-1)||(k==0))
        {
            String s=new String(str);
            return s;
        }

        int max=Integer.parseInt(str[index]+""), max_pos=index;
        for(int i=str.length-1; i>index; i--)
        {
            int temp=Integer.parseInt(str[i]+"");
            if(max<temp)
            {
                max=temp;
                max_pos=i;
            }
        }
        if(max_pos!=index)
        {
            char temp=str[max_pos];
            str[max_pos]=str[index];
            str[index]=temp;
            return function(str, k-1, index+1);
        }
        else 
            return function(str, k, index+1);
    }

    //  END
}
