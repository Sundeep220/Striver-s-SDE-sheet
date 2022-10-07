package com.Sundeep;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeTraversals {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);
        System.out.println(preOrder(root));
        System.out.println(inOrderTrav(root));
        System.out.println(postOrderTrav(root));

//        System.out.print("The inOrder Traversal is : ");
//        System.out.println(inOrderTrav(root));
    }

    //Iterative preorder, inorder,postorder traversals
    public static List<Integer> preOrder(Node root){
        List<Integer> ans = new ArrayList<>();
        Stack<Node> s = new Stack<>();
        if(root == null)
            return ans;
        s.push(root);
        while(!s.isEmpty()){
            Node temp = s.peek();
            ans.add(s.peek().data);
            s.pop();
            if(temp.right != null){
                s.push(temp.right);
            }
            if(temp.left != null){
                s.push(temp.left);
            }
        }
        return ans;
    }

    static ArrayList < Integer > inOrderTrav(Node curr) {
        ArrayList < Integer > inOrder = new ArrayList < > ();
        Stack < Node > s = new Stack < > ();
        while (true) {
            if (curr != null) {
                s.push(curr);
                curr = curr.left;
            } else {
                if (s.isEmpty()) break;
                curr = s.peek();
                inOrder.add(curr.data);
                s.pop();
                curr = curr.right;
            }
        }
        return inOrder;
    }

    static ArrayList < Integer > postOrderTrav(Node cur) {

        ArrayList < Integer > postOrder = new ArrayList < > ();
        if (cur == null) return postOrder;

        Stack < Node > st = new Stack < > ();
        while (cur != null || !st.isEmpty()) {

            if (cur != null) {
                st.push(cur);
                cur = cur.left;
            } else {
                Node temp = st.peek().right;
                if (temp == null) {
                    temp = st.peek();
                    st.pop();
                    postOrder.add(temp.data);
                    while (!st.isEmpty() && temp == st.peek().right) {
                        temp = st.peek();
                        st.pop();
                        postOrder.add(temp.data);
                    }
                } else cur = temp;
            }
        }
        return postOrder;


    }

}
