package Recursion_practice;
import java.io.*;
import java.util.*;
public class prob33 {
    public static void main(String []args)throws IOException
    {
        BufferedReader x=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(x.readLine());
        for(int i=0; i<t; i++)
        {   
            String input[]=(x.readLine()).split(" ");
            int A=Integer.parseInt(input[0]);
            int B=Integer.parseInt(input[1]);
            int C=Integer.parseInt(input[2]);
            int D=Integer.parseInt(input[3]);
            System.out.println(answer(A, B, C, D)==true?"yes":"no");
        }
    }
    static boolean answer(long A, long B, long C, long D)
    {
        System.out.println(A+" "+B+" "+C+" "+D);
        
        if(D<0)
            return false;
        
        if(A==C)
            return true;
        
        return answer(A+B, B, C, D-1)||answer(A-B, B, C, D-1);
    }
}
