package Recursion_practice;
import java.io.*;
import java.util.*;
public class dummy4 {
    public static void main(String args[])throws IOException
    {
        String A="1010110111001101101000";
        String B="1000011011000000111100110";
       System.out.println(A+" + "+B+" = "+addBinary(A, B));
    }
    public static String addBinary(String A, String B) {
        int carry=0; String answer="";
        int A_index=A.length()-1;
        int B_index=B.length()-1;
        while((A_index>=0)||(B_index>=0))
        {
            int A_temp=0, B_temp=0, temp_res=0;
            if(A_index>=0)
                A_temp=Integer.parseInt(A.charAt(A_index)+"");
            if(B_index>=0)
                B_temp=Integer.parseInt(B.charAt(B_index)+"");
            
            if(A_temp+B_temp+carry==3)
                {temp_res=1;carry=1;}   
            else if(A_temp+B_temp+carry==2)
                {temp_res=0;carry=1;}
            else if(A_temp+B_temp+carry==1)
                {temp_res=1; carry=0;}
            else
                {temp_res=0; carry=0;}
            
            answer=temp_res+answer;
            --A_index;
            --B_index;
        }
        if(carry!=0){
            answer=carry+answer;
        }
        return answer;
    }
}
