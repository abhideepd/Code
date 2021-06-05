package Recursion_practice;
import java.io.*;
import java.util.*;
public class prob8 {
    public static void main(String args[])throws IOException
    {
        BufferedReader x=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(x.readLine());
        while(t-->0)
        function(x.readLine().split(" "));
    }
    static void function(String []inp)
    {
        int A=Integer.parseInt(inp[0]);
        int B=Integer.parseInt(inp[1]);
        int C=Integer.parseInt(inp[2]);
        int N=Integer.parseInt(inp[3]);
        //System.out.print("Answer: ");
        System.out.println(answer(A,B,C,N-3));
    }
    static int answer(int A, int B, int C, int N)
    {
        if(N==1)
        return A+B+C;
        int temp=A+B+C;
        A=B;
        B=C;
        C=temp;
        return answer(A,B,C,N-1);
    }
}
