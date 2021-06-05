package Recursion_practice;

public class prob4 {
    public static void main(String []args){
        int N=6;
        gfSeries(N);
    }
    static void gfSeries(int N){
        // code here
        int arr[]=new int[N+1];
        arr[1]=0;
        arr[2]=1;
        Tn(N, arr);
        for(int i:arr)
        System.out.print(i+" ");
    }
    static int[] Tn(int N, int[] arr){
        // code here
       // if(N<=2)
        return arr;
       // arr[N]=arr[N-2]
    }
}
