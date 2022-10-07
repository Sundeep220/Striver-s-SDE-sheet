package com.Sundeep;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreInPostinOneTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        preInPost(root,pre,in,post);
        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);


    }

    public static void preInPost(Node root,List<Integer> pre,List<Integer> in,List<Integer> post){
        Stack<pair> s= new Stack<>();
        if(root == null)
            return;
        s.push(new pair(root,1));
        while(!s.isEmpty()){
            pair temp = s.pop();
            if(temp.num == 1){
                pre.add(temp.node.data);
                temp.num++;
                s.push(temp);

                //check if left is present or not , if present push it also on stack
                if(temp.node.left != null){
                    s.push(new pair(temp.node.left,1));
                }
            }
            else if(temp.num == 2){
                in.add(temp.node.data);
                temp.num++;
                s.push(temp);

                if(temp.node.right != null){
                    s.push(new pair(temp.node.right,1));
                }
            }
            else {
                //do nothing add it to post order
                post.add(temp.node.data);
            }
        }
    }
}

class pair{
    Node node;
    int num;
    pair(Node node, int data){
        this.node = node;
        this.num = data;
    }
}
