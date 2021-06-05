package Recursion_practice;
import java.io.*;
import java.util.*;
public class prob20 {
    public static void main(String []args)
    {
        Queue<Integer> q=new LinkedList<Integer>();
        for(int i=1; i<=100; i++)
            q.add(i);
        int c=1;
        while(q.size()!=1)
        {
            int temp=q.poll();
            if(c==1)
            {
                c=2;
                q.add(temp);
            }
            else if(c==2)
            {
                c=1;
            }
        }
        System.out.println(q.peek());
    } 
}
