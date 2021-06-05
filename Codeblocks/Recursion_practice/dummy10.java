package Recursion_practice;
import java.io.*;
import java.util.*;
public class dummy10 {
    public static void main(String []args)throws IOException
    {
        ArrayList<String> answer;
        String input;

        // input="11211";
        // answer=new dummy10().genIp(input);

        // input="1111";
        // answer=new dummy10().genIp(input);

        // input="11211";
        // answer=new dummy10().genIp(input);

        // input="237592";
        // answer=new dummy10().genIp(input);

        // input="50361";
        // answer=new dummy10().genIp(input);

        // input="67535629";
        // answer=new dummy10().genIp(input);

        // input="25525511135";
        // answer=new dummy10().genIp(input);

        // input="93606261879";
        // answer=new dummy10().genIp(input);

        // input="0279245587303";
        // answer=new dummy10().genIp(input);

        // for(String i:answer)
        // System.out.println(i);

        function2();
    }

    static void function2()throws IOException
    {
        BufferedReader x=new BufferedReader(new InputStreamReader(System.in));
        String arr[]={"67535629", "237592", "50361", "11211", "1111", "25525511135", "0000", "010010", "101023", "93606261879", "0279245587303"};
        int t=arr.length;
        while(--t>=0)
        {
            String s=arr[t];
            // String s=x.readLine();
            dummy10 sln=new dummy10();
            ArrayList<String> str=sln.genIp(s);
            Collections.sort(str);
            System.out.println("Input: "+s);
            for(String u:str){
                System.out.println(u);
            }
            System.out.println();
        }
    }

    //  START

    public ArrayList<String> genIp(String s) 
    {
        // code here
        ArrayList<String> answer=new ArrayList<String>();
        function(s, 0, 0, answer);
        return answer;
    }
    void function(String s, int counter, int i, ArrayList<String> answer)
    {
        if(counter==3)
        {
            String temp=s.substring(i, s.length());
            if(temp.length()>3)return;
            int ip=Integer.parseInt(temp);

            if((temp.length()>1)&&(temp.charAt(0)=='0'))
            return;
            if(ip<=255)
            answer.add(s);

            return;
        }
        
        String ip_digit="";
        for(int j=i; j<s.length()-1; j++)
        {
            ip_digit=ip_digit+s.charAt(j);
            int c=Integer.parseInt(ip_digit);
            
            if((s.charAt(j)!='.')&&(c<=255))
            {
                String temp=s.substring(0, j+1)+'.'+s.substring(j+1, s.length());
                function(temp, counter+1, j+2, answer);
            }
            else
            return;

            if(c==0)return;
        }
    }

    //  END
}
