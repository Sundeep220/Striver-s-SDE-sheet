package com.Sundeep;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrderTraversal {
    //Using iteration
    public List<List<Integer>> levelOrder(Node root){
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        queue.offer(root);
        while(!queue.isEmpty()){
            int level = queue.size();
            List<Integer> subAns = new ArrayList<>();
            for(int i=1;i<=level;i++){
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subAns.add(queue.poll().data);
            }
            ans.add(subAns);
        }
        return ans;
    }

    //Using recursion
    public List<List<Integer>> levelOrderRec(Node root) {
        List<List<Integer>> a = new ArrayList();
        LevelOrder(root,0,a); //a new function to add nodes to list
        return a;
    }

    public void LevelOrder(Node root,int curlevel,List<List<Integer>> a){
        if(root == null)  //If a node is null do nothing and return.(Base Case)
            return;
        if(a.size() <curlevel + 1)   //for each level create a new list within the list
            a.add(new ArrayList<>());
        a.get(curlevel).add(root.data); //add values of nodes for each level in the list
        LevelOrder(root.left,curlevel+1,a);  //callback to same function for left and right
        LevelOrder(root.right,curlevel+1,a); //child-(Recursive Leap of Faith).
    }
}
