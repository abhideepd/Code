package Recursion_practice;
import java.io.*;
import java.util.*;
public class dummy3 {
    public static void main(String []args)throws IOException
    {
        BufferedReader x=new BufferedReader(new InputStreamReader(System.in));
        String input[]=(x.readLine()).split(" ");
        boolean toggle=true;
        Node prev=null;
        Node head=null;
        for(String i:input){
            if(!i.equals("N")){
                int temp=Integer.parseInt(i);
                Node node=new Node(temp);
                if(prev==null){
                    head=node;
                    prev=node;
                }
                else if(toggle==true){
                    prev.left=node;
                    prev=node;
                    toggle=false;
                }
                else{
                    prev.right=node;
                    prev=node;
                    toggle=true;
                }
            }
            else{
                if(toggle==true){
                    toggle=false;
                }
                else{
                    toggle=true;
                }
            }
        }
        // display(head);
        levelordertraversal(head);
    }
    static void display(Node n){
        if(n==null)return;
        System.out.print(n.data+" ");
        display(n.left);
        display(n.right);
    }
    static void levelordertraversal(Node node){
        Queue<Node> bfs=new LinkedList<Node>();
        ArrayList<Integer> arr=new ArrayList<Integer>();
        bfs.add(node);
        while(!bfs.isEmpty())
        {
            Node temp=bfs.poll();
            // System.out.print(temp.data+" ");
            arr.add(temp.data);
            if(temp.left!=null)bfs.add(node.left);
            if(temp.right!=null)bfs.add(node.right);
        }
        System.out.println(arr);
    }
}
class Node{
    int data;
    Node left, right;
    Node(int item){
        data=item;
        left=right=null;
    }
}