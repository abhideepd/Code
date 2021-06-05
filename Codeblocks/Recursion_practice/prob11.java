package Recursion_practice;
import java.util.*;
public class prob11 {
    public static void main(String angs[])
    {
        //String input="A";
        //String input="AB";
        String input="ABC";
        //String input="ABCD";
    List<String> answer=new Solution9().find_permutation(input);
    System.out.println(answer);
}
}
class Solution9 {
    static List<String> answer=new ArrayList<String>();
    public List<String> find_permutation(String S) {
        // Code here
        sperm(S, 0);
        Collections.sort(answer);
        return answer;
    }
    static void sperm(String S, int index)
    {
        if(answer.indexOf(S)==-1)answer.add(S);
        for(int i=index; i<S.length(); i++)
        {
            sperm(swap(S, index, i), index+1);
        }
    }
    static String swap(String S, int a, int b)
    {
        char arr[]=S.toCharArray();
        char temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
        String s="";
        for(char c:arr)
        s=s+c;
        //System.out.println(S+" "+a+" "+b+" "+s);
        return s;
    }
}   