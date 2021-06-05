package Recursion_practice;
import java.io.*;
import java.util.*;
public class dummy7 {
    public static void main(String args[])throws IOException
    {
        // int a[]={2,3,4};
        // print(a);

        int b[]={3,4,5};
        print(b);

        // int c[]={};
        // print(c);

        // int d[]={};
        // print(d);

        // int e[]={};
        // print(e);
    }
    static void print(int []a)
    {
        ArrayList<String> ans=possibleWords(a, a.length);
        StringBuilder answer=new StringBuilder();
        for(String s:ans)
        answer.append(s+" ");
        System.out.println(answer);
    }

    //  START 
    
    static ArrayList<ArrayList<Character>> keypad=new ArrayList<ArrayList<Character>>();
    static ArrayList<String> answer;
    static ArrayList<String> possibleWords(int a[], int N)
    {
        answer=new ArrayList<String>();

        ArrayList<Character> temp=new ArrayList<Character>();
        temp.add('0');
        keypad.add(temp);   //  0
        keypad.add(temp);   //  1

        temp=new ArrayList<Character>();
        temp.add('a');
        temp.add('b');
        temp.add('c');
        keypad.add(temp);   //  2

        temp=new ArrayList<Character>();
        temp.add('d');
        temp.add('e');
        temp.add('f');
        keypad.add(temp);   //  3

        temp=new ArrayList<Character>();
        temp.add('g');
        temp.add('h');
        temp.add('i');
        keypad.add(temp);   //  4

        temp=new ArrayList<Character>();
        temp.add('j');
        temp.add('k');
        temp.add('l');
        keypad.add(temp);   //  5

        temp=new ArrayList<Character>();
        temp.add('m');
        temp.add('n');
        temp.add('o');
        keypad.add(temp);   //  6

        temp=new ArrayList<Character>();
        temp.add('p');
        temp.add('q');
        temp.add('r');
        temp.add('s');
        keypad.add(temp);   //  7

        temp=new ArrayList<Character>();
        temp.add('t');
        temp.add('u');
        temp.add('v');
        keypad.add(temp);   //  8

        temp=new ArrayList<Character>();
        temp.add('w');
        temp.add('x');
        temp.add('y');
        temp.add('z');
        keypad.add(temp);   //  9

        function("", a, 0);
        return answer;
    }
    static void function(String s, int []a, int i)
    {
        if(s.length()==a.length)
        {
            answer.add(s);
            return;
        }

        for(; i<a.length; i++)
        {
            ArrayList<Character> keys=keypad.get(a[i]);
            for(char j:keys)
            {
                String temp_s=s+j;
                function(temp_s, a, i+1);
            }
        }
    }

    //  END
}
