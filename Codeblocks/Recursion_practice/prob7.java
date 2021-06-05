package Recursion_practice;
import java.util.*;
import java.io.*;
public class prob7 {
    public static void main(String []args)throws IOException
    {
        BufferedReader x=new BufferedReader(new InputStreamReader(System.in));
        String input="ABC";
        //String input="ABC";
        List<String> answer = new Solution3().find_permutation(input);
        System.out.println(answer);
    }
}
class Solution3 {
    static List<String> answer = new ArrayList<String>();
    public List<String> find_permutation(String S) {
        // Code here
        //List<String> answer = new ArrayList<String>();
        permutation(S, 0);
        return answer;
    }
    static void permutation(String S, int index)
    {
        for(int i=index; i<S.length(); i++)
        {
            S=swap(index, i, S);
            System.out.println(S);
            answer.add(S);
            permutation(S, i+1);
            //S=swap(index, i, S);
            System.out.println(S);
        }
    }
    static String swap(int a, int b, String S)
    {
        char temp[]=S.toCharArray();
        char temp1=temp[a];
        temp[a]=temp[b];
        temp[b]=temp1;
        String temp2=new String(temp);
        //System.out.println(temp2);
        return temp2;
    }
}