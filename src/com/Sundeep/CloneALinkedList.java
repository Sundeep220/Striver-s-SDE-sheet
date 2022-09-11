package com.Sundeep;

public class CloneALinkedList {
    public Node copyRandomList(Node head) {
        //Using constant space with O(N) time
        //Instead of using a hashmap to create links between node, just create links by adding nodes in between
        Node cur  = head;
        if(head == null)
            return null;
        //Creating links between nodes
        while(cur != null){
            Node temp = cur.next;
            Node newNode = new Node(cur.val);
            cur.next = newNode;
            newNode.next = temp;
            cur = temp;
        }

        //setting random pointers for nodes
        cur = head;
        while(cur != null && cur.next != null) {
            if(cur.next != null){
                cur.next.random = (cur.random != null)?cur.random.next : null;
            }
            cur = cur.next.next;
        }

        //Seperating the two lists
        Node og = head;
        Node copy = head.next;
        Node temp = copy;
        while(og != null){
            if(og.next != null)
                og.next = og.next.next;
            if(temp.next != null)
                temp.next = temp.next.next;
            og = og.next;
            temp = temp.next;
        }
        return copy;
    }
}
