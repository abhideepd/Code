package Recursion_practice;
import java.io.*;
import java.util.*;
public class prob35 {
    public static void main(String []args)throws IOException
    {
        BufferedReader x=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(x.readLine());
        for(int i=0; i<t; i++)
        {
            String input_matrix_size[]=(x.readLine()).split(" ");
            int r=Integer.parseInt(input_matrix_size[0]);
            int c=Integer.parseInt(input_matrix_size[1]);
            int arr[][]=new int[r][c];
            for(int j=0; j<r; j++)
            {
                String input_row=x.readLine();
                for(int k=0; k<c; k++)
                {
                    arr[j][k]=Integer.parseInt(input_row.charAt(k)+"");
                }
            }
            System.out.println(answer(arr));
        }
    }
    static int answer(int [][]arr)
    {
        int answer=0;
        int [][]completed=new int[arr.length][arr[0].length];
        for(int i=0; i<arr.length; i++)
        {
            for(int j=0; j<arr[i].length; j++)
            {
                if((arr[i][j]==1)&&(completed[i][j]!=1))
                {
                    int temp=cluster_size(arr, completed, i, j);
                    // System.out.println("x:"+i+" y:"+j+" cluster_size:"+temp);
                    answer=Math.max(answer, temp);
                }
            }
        }
        return answer;
    }
    static int cluster_size(int [][]arr, int [][]completed, int x, int y)
    {
        if((x<0)||(y<0)||(x>=arr.length)||(y>=arr[0].length)||(arr[x][y]==0)||(completed[x][y]==1))
            return 0;
        completed[x][y]=1;
        // x+1, y
        // x-1, y
        // x, y+1
        // x, y-1
        // x-1, y-1
        // x-1, y+1
        // x+1, y-1
        // x+1, y+1
        return 1+cluster_size(arr, completed, x+1, y)+cluster_size(arr, completed, x+1, y+1)+cluster_size(arr, completed, x+1, y-1)+cluster_size(arr, completed, x, y+1)+cluster_size(arr, completed, x-1, y-1)+cluster_size(arr, completed, x, y-1)+cluster_size(arr, completed, x-1, y+1)+cluster_size(arr, completed, x-1, y);
    }
}
