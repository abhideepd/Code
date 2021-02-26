package Javascripts;
import java.io.*;
import java.util.*;
public class xyz
{
    public static void main(String []args)throws IOException
    {
        BufferedReader x=new BufferedReader(new InputStreamReader(System.in));
        //String input=x.readLine();

        String input="abcd";

        char inp[]=input.toCharArray();
        answer(inp, 0, "");
    }
    static void answer(char[] arr, int index, String ans)
    {
        if(index==arr.length)
        index=0;

        if(ans.length()==arr.length)
        {
            System.out.println(ans);
            return;
        }

        for(int i=index; i<arr.length; i++)
        {
            if(arr[i]!='0')
            {
                char temp=arr[i];
                arr[i]='0';
                answer(arr, i+1, ans+temp);
                arr[i]=temp;
            }
        }
    }
}