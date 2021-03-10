
package Recursion_practice;
import java.io.*;
import java.util.*;
class prob1
{
    static HashMap<String, Integer> hh=new HashMap<String, Integer>();
    public static void main(String []args)throws IOException
    {
        BufferedReader x=new BufferedReader(new InputStreamReader(System.in));
        //String inp=x.readLine();
        String inp="ABC";
        List<String> s=new prob1().find_permutation(inp);
        for(String i:s)
        System.out.println(i);
    }
    public List<String> find_permutation(String S) {
        // Code here
        List<String> s=new ArrayList<String>();
        char []str_array=S.toCharArray();
        //System.out.println(str_array);        
        func(str_array, s, 0);
        System.out.println(hh);
        return s; 
    }
    static void func(char arr[], List<String> ans, int index)
    {
        //String s=new String(arr); 
        //ans.add(s);
        for(int i=index; i<arr.length; i++)
        {
            swap(arr, index, i);            
            //System.out.println(arr);
            String s=new String(arr); 
            //ans.add(s);
            hh.put(s, 0);
            func(arr, ans, i+1);
            swap(arr, index, i);
            //System.out.println(arr);
        }
    }
    static void swap(char[] arr, int a, int b)
    {
        char temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
        System.out.print(a+" "+b+" ");
        System.out.println(arr);
    }
}