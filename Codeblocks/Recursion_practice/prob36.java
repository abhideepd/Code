package Recursion_practice;
import java.io.*;
import java.util.*;
public class prob36 {
    public static void main(String args[])
    {
        System.out.println(new SolutionXXXXXX().isLucky(300));
        System.out.println(new SolutionXXXXXX().isLucky(19));
        System.out.println(new SolutionXXXXXX().isLucky(2));
    }
}
class SolutionXXXXXX
{
    // Complete the function
    // n: Input n
    // Return True if the given number is a lucky number else return False
    public static boolean isLucky(int n)
    {
        // Your code here
        ArrayList<Integer> arr=new ArrayList<Integer>();
        int n1=n;
        do{
            arr.add(0, n);
        }while(--n>0);

        return check(arr, 2, n1);
    }
    public static boolean check(ArrayList<Integer> arr, int jump, int no)
    {
        if(arr.indexOf(no)==-1)
            return false;

        if(jump>arr.size())
            return true;

        ArrayList<Integer> temp=new ArrayList<Integer>();

        for(int i=0; i<arr.size(); i++)
        {
            if((i+1)%jump==0)
                continue;
            temp.add(arr.get(i));
        }
        System.out.println(temp);
        return check(temp, jump+1, no);
    }
} 