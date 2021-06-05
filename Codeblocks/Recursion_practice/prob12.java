package Recursion_practice;
import java.util.*;
public class prob12 {
    public static void main(String []args)
    {
        //String input="A";
        //String input="AB";
        String input="ABC";
        //String input="ABCD";
        System.out.println(new Solution11().find_permutation(input));
    }
}
class Solution11 {
    public List<String> find_permutation(String S) {
        // Code here
        return permutation(S, 0);
    }
    public List<String> permutation(String S, int index)
    {
        if(index==S.length()-1)
        {   
            List<String> res=new ArrayList<String>();
            res.add(S.charAt(index)+"");
            return res;
        }
        List<String> result=permutation(S, index+1);
        List<String> temp=new ArrayList<String>();
        for(String ele:result)
        {
            String temp1=ele+S.charAt(index);
            String temp2=S.charAt(index)+ele;
            temp.add(temp1);
            temp.add(temp2);
            System.out.println(temp1+" "+temp2);
        }
        return temp;
    }
}