package Recursion_practice;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.io.File;
public class prob16 {

    // Complete the poisonousPlants function below.
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
    public static void main(String[] args) throws IOException {

        File file = new File("/home/dRazz3R/Documents/Code/Real Life/Code/Codeblocks/Recursion_practice/inp.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        int n=Integer.parseInt(br.readLine());
        int p[]=new int[n];
        String file_input[]=(br.readLine()).split(" ");

        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(file_input[i]);
        }

        int result = poisonousPlants(p);

        System.out.println(result);
        br.close();
    }
}
