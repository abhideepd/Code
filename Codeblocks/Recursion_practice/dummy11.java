package Recursion_practice;
import java.io.*;
import java.util.*;
public class dummy11 {
    public static void main(String []args)throws IOException
    {
        System.out.println(solve(2, 2));
        System.out.println(solve(2, 3));
        // System.out.println(solve(2, 2));
    }

    //  START

    static long solve(int N, int M)
    {
        // add your code here
        long ans=0;
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                ans=ans+N*M-1;
                int pos_x=0;
                int pos_y=0;

                pos_x=i-2;
                pos_y=j+1;
                if(check(pos_x, pos_y, N, M))
                {
                    print(i, j, pos_x, pos_y);
                    --ans;
                }

                pos_x=i-2;
                pos_y=j-1;
                if(check(pos_x, pos_y, N, M))
                {
                    print(i, j, pos_x, pos_y);
                    --ans;
                }

                pos_x=i+2;
                pos_y=j-1;
                if(check(pos_x, pos_y, N, M))
                {
                    print(i, j, pos_x, pos_y);
                    --ans;
                }
                
                pos_x=i+2;
                pos_y=j+1;
                if(check(pos_x, pos_y, N, M))
                {
                    print(i, j, pos_x, pos_y);
                    --ans;
                }

                pos_x=i-1;
                pos_y=j+2;
                if(check(pos_x, pos_y, N, M))
                {
                    print(i, j, pos_x, pos_y);
                    --ans;
                }

                pos_x=i-1;
                pos_y=j-2;
                if(check(pos_x, pos_y, N, M))
                {
                    print(i, j, pos_x, pos_y);
                    --ans;
                }

                pos_x=i+1;
                pos_y=j+2;
                if(check(pos_x, pos_y, N, M))
                {
                    print(i, j, pos_x, pos_y);
                    --ans;
                }

                pos_x=i+1;
                pos_y=j-2;
                if(check(pos_x, pos_y, N, M))
                {
                    print(i, j, pos_x, pos_y);
                    --ans;
                }
            }
            // System.out.println();
        }
        return ans;
    }
    static void print(int i, int j, int pos_x, int pos_y)
    {
        // System.out.println("i:"+i+" j:"+j+" pos_x:"+pos_x+" pos_y:"+pos_y);
    }
    static boolean check(int pos_x, int pos_y, int N, int M)
    {
        return ((pos_x>-1)&&(pos_y>-1)&&(pos_x<N)&&(pos_y<M));
    }

    //  END
}
