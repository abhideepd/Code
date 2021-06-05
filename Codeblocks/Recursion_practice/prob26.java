package Recursion_practice;
import java.io.*;
import java.util.*;
public class prob26 {
    public static void main(String []args){

    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0)
    {
        int N=sc.nextInt();
        
        Solutionnnnn ob = new Solutionnnnn();
        ob.gfSeries(N);
        
    }
}
}
class Solutionnnnn{
    int first_term=0, second_term=1;   
    void gfSeries(int N){
        // code here
        int ans=0;
        if(N==1)
            ans=first_term;
        else if(N==2)
        {
            ans=second_term;
            gfSeries(N-1);
        }
        else
        {
            gfSeries(N-1);
            ans=first_term*first_term-second_term;
            first_term=second_term;
            second_term=ans;
        }
        System.out.print(ans+" ");
    }
}