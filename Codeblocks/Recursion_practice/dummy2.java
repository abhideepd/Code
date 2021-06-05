package Recursion_practice;
import java.io.*;
import java.util.*;
public class dummy2 {
    public static void main(String []args)throws IOException
    {
        System.out.println(new SolutionUUUXUXUX().isLucky(5));
        System.out.println(new SolutionUUUXUXUX().isLucky(19));
        // System.out.println(new SolutionUUUXUXUX().isLucky());
        // System.out.println(new SolutionUUUXUXUX().isLucky());
        // System.out.println(new SolutionUUUXUXUX().isLucky());
    }
}
class SolutionUUUXUXUX
{
    // Complete the function
    // n: Input n
    // Return True if the given number is a lucky number else return False
    public static boolean isLucky(int n)
    {
        // Your code here
        Queue<Integer> q=new LinkedList<Integer>();
        for(int i=1; i<=n; i++){
            q.add(i);
        }
        int k=1;
        while((!q.isEmpty())&&(++k<=n)){
            int temp=k, size=q.size();
            for(int i=0; i<size; i++)
            {
                if(temp==1){
                    temp=k;
                    if(q.poll()==n)
                        return false;
                }
                else{
                    --temp;
                    q.add(q.poll());
                }
            }
        }
        return true;
    }
}