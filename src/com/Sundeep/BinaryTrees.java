package com.Sundeep;

import java.security.KeyPair;
import java.util.*;
class Node {
    Node left, right;
    int data;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class Main {

    static Scanner sc = null;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        ArrayList<Integer> c = new ArrayList<>();

        Node root = createTree();
//        ArrayList<Integer> a = topView(root);
//        for(int b: a)
//            System.out.print(b+" ");
//
//        c = topView(root);
        inOrder(root,c);
        System.out.println(c);
    }

    static Node createTree() {

        Node root = null;
        System.out.println("Enter data: ");
        int data = sc.nextInt();

        if (data == -1) return null;

        root = new Node(data);

        System.out.println("Enter left for " + data);
        root.left = createTree();

        System.out.println("Enter right for " + data);
        root.right = createTree();

        return root;
    }

    static void inOrder(Node root,ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }

        inOrder(root.left,ans);
        ans.add(root.data);
        inOrder(root.right,ans);
    }

    static void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static void postOrder(Node root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    //Height of Binary Tree.
    public int height(Node root) {
        if (root == null)
            return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    //Size of Binary Tree
    public int size(Node root) {
        if (root == null)
            return 0;
        return size(root.left) + size(root.right) + 1;
    }

    //Maximum in a Binary tree
    int maximum(Node root) {
        if (root == null)
            return Integer.MIN_VALUE;
        return Math.max(root.data, Math.max(maximum(root.left), maximum(root.right)));
    }
    //Level Order Traversal :: Brute Force technique

    void printLevelOrder(Node root) {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++)
            printCurrentLevel(root, i);
    }

    void printCurrentLevel(Node root, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1) {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }

    }

    //Level Order Traversal :: QUEUE implementation
    void printQueueLevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {

            /* poll() removes the present head.
            For more information on poll() visit
            */
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            /*Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            /*Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    //Left VIew of Binary Tree
    void leftView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        leftViewUtil(root, list, 0);
//        for (Node cur : list) {
//            System.out.println(cur.data);
//        }
        System.out.println(list);
    }
    void leftViewUtil(Node node,ArrayList l, int level)
    {
        // Base Case
        if (node == null)
            return;

        // If this is the first node of its level


        if (l.get(level) == null) {
            l.set(level,node.data);
        }

        // Recur for left and right subtrees
        leftViewUtil(node.left, l,level + 1);
        leftViewUtil(node.right, l,level + 1);
    }
    //For right view you can do 2 things:
    // 1. You can reverse the recursive call like, in line 148 and 149 you can call the leftviewutil for right node first.
    // 2. You can remove the condition on line 143 and just write l.set() as it is.

    //Top VIew of Binary tree


    static ArrayList<Integer> topView(Node root)
    {
        Queue<Pair> q= new ArrayDeque<>();   //we need to do Level order traversal and so the queue and we need to map hd with the node so the type we need is Pair which we created as new class
        Map<Integer,Integer> map = new TreeMap<>();  //Maps the Horizontal dist(hd) with the node's data

        q.add(new Pair(0,root));
        while(!q.isEmpty()){
            Pair cur = q.poll();
            if(!map.containsKey(cur.hd)){
                map.put(cur.hd,cur.node.data);
            }

            if(cur.node.left != null){
                q.add(new Pair(cur.hd-1,cur.node.left ));
            }

            if(cur.node.right != null){
                q.add(new Pair(cur.hd+1,cur.node.right));
            }
        }
        ArrayList<Integer> a = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            a.add(entry.getValue());
        }
        return a;

    }

    static ArrayList<Integer> bottomView(Node root)
    {
        Queue<Pair> q= new ArrayDeque<>();   //we need to do Level order traversal and so the queue and we need to map hd with the node so the type we need is Pair which we created as new class
        Map<Integer,Integer> map = new TreeMap<>();  //Maps the Horizontal dist(hd) with the node's data

        q.add(new Pair(0,root));
        while(!q.isEmpty()){
            Pair cur = q.poll();
            map.put(cur.hd,cur.node.data);

            if(cur.node.left != null){
                q.add(new Pair(cur.hd-1,cur.node.left ));
            }

            if(cur.node.right != null){
                q.add(new Pair(cur.hd+1,cur.node.right));
            }
        }
        ArrayList<Integer> a = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            a.add(entry.getValue());
        }
        return a;

    }

}


class Pair{
    int hd;
    Node node;
    public Pair(int hd,Node node){
        this.hd = hd;
        this.node = node;
    }
}
