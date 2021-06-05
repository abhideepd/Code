package Recursion_practice;
import java.io.*;
import java.util.*;
public class dummy5 {
    public static void main(String args[])throws IOException
    {
        BufferedReader x=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(x.readLine());
        while(T-->0)
        {
            String input=x.readLine();
            answer=new ArrayList<String>();
            function(input, 0);
            print();
        }
    }
    static void print()
    {
        StringBuilder ans=new StringBuilder();
        for(String s:answer)
        ans.append(s+" ");
        System.out.println(ans+" ");
    }
    static ArrayList<String> answer;
    static void function(String s, int i)
    {
        for(; i<s.length(); i++)
        {
            if(Character.isDigit(s.charAt(i)))
            {
                char temp_s[]=s.toCharArray();

                temp_s[i]='!';
                String temp1=new String(temp_s);

                temp_s[i]='*';
                String temp2=new String(temp_s);

                temp_s[i]='@';
                String temp3=new String(temp_s);

                function(temp1, i+1);
                function(temp2, i+1);
                function(temp3, i+1);
                return;
            }
        }
        answer.add(s);
    }
}
