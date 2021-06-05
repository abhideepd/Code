package Recursion_practice;
import java.io.*;
import java.util.*;
public class prob15 {
    public static void main(String []args)
    {
        //  Determine the number of days after which no plant dies
        //  no plant with "more pesticide content" than the plant to its left

        // int inp[]={5,4,3,2,1};
        // int inp[]={6, 5, 8, 4, 7, 10, 9};
        int inp[]={3,6,2,7,5};
        
        System.out.println(poisonousPlants(inp));
    }
    static int poisonousPlants(int[] p) {

    // 1st step - nos. greater than next-left number is removed

        int ans=0;
        if(p.length==1)
        return 0;
        ArrayList<Integer> ss=new ArrayList<Integer>();
        for(int i=0; i<p.length; i++)
        {
            ss.add(p[i]);
        }
        ans=result(ss, ans);
        return ans;
    }
    static int result(ArrayList<Integer> inp, int ans)
    {
        if(inp.size()<2)
        return ans;
        while(true){
            ArrayList<Integer> temp=new ArrayList<Integer>();
            boolean check=true;
            //System.out.println(inp);
            temp.add(inp.get(0));
            for(int i=1; i<inp.size(); i++)
            {
                //System.out.println(inp.get(i)+">"+inp.get(i-1)+" "+(inp.get(i)>inp.get(i-1)));
                if(inp.get(i)>inp.get(i-1))
                {check=false;continue;}
                else
                temp.add(inp.get(i));
            }
            //System.out.println(temp);
            if(temp.size()!=inp.size())
            ++ans;
            if(check)
            return ans;
        //return result(temp, ans);
            inp=temp;
        }
    }
}
