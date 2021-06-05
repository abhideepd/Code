package Recursion_practice;
import java.io.*;
import java.util.*;
public class prob34 {
    public static  void main(String []args)
    {
        // int arr[]={1};
        // int arr[]={2, 1};
        // int arr[]={3, 2, 1};
        int arr[]={11, 2, 32, 3, 41};

        Stack<Integer> ss=new Stack<Integer>();

        for(int i=arr.length-1; i>=0; i--)
        {
            // System.out.println(i);
            ss.push(arr[i]);
        }

        // for(int i:arr)System.out.print(i+" ");
        System.out.println("\n"+new XXXGfG().sort(ss)+"\n");
    }
}
class XXXGfG{
	public Stack<Integer> sort(Stack<Integer> s)
	{
		//add code here.
        if(s.size()==1)
            return s;
        int first=s.pop();
        int second=s.pop();
        if(first<second)
        {
            int temp=first;
            first=second;
            second=temp;
        }
        s.push(second);
        Stack<Integer> temp=sort(s);
        temp.push(first);
        return s;
	}
}