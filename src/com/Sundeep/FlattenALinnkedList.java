package com.Sundeep;

public class FlattenALinnkedList {
    Node flatten(Node root)
    {
        // Your code here
        if(root == null || root.next == null)
            return root;

        root.next = flatten(root.next);

        //After comming back merge the root with this current root element
        root = merge(root,root.next);

        return root;

    }

    Node merge(Node a, Node b){
        Node dummy = new Node(0);
        Node res = dummy;
        while(a != null && b != null){
            if(a.data < b.data){
                dummy.bottom = a;
                dummy = dummy.bottom;
                a = a.bottom;
            }
            else{
                dummy.bottom = b;
                dummy = dummy.bottom;
                b = b.bottom;
            }

        }
        dummy.bottom = (a != null)? a:b;
        return res.bottom;

    }
}
