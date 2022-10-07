package com.Sundeep;

import javax.management.ListenerNotFoundException;
import java.awt.geom.Line2D;
import java.util.List;

public class Linkedlist {
    Node head;
    Node tail;
    int size;

    public Linkedlist(){
        size = 0;
    }

    public void insertFirst(int data){
        Node newnode = new Node(data);
        newnode.next = head;
        head = newnode;
        if(tail == null)
            tail = head;
        size++;
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("END");
    }

    public void insertLast(int data){
        if(tail == null){
            insertFirst(data);
            return;
        }
        Node node =new Node(data);
        tail.next = node;
        tail = node;

        size++;
    }

    public void insert(int data,int pos){
        if(pos == 0){
            insertFirst(data);
            return;
        }
        if(pos == size){
            insertLast(data);
            return;
        }
        Node temp = head;
        for(int i=1;i<pos;i++){
            temp = temp.next;
        }
        Node node = new Node(data,temp.next);
        temp.next = node;

        size++;
    }

    public int deleteFirst(){
        int d = head.data;
        head = head.next;
        if(head == null)
            tail = null;
        size--;
        return d;

    }

    public int deleteLast(){
        if(size <= 1){
            return deleteFirst();
        }
        int val = tail.data;
        Node secondlast = getnode(size-2);
        tail = secondlast;
        tail.next = null;

        size--;

        return val;
    }

    public int deletePos(int index){
        if(index==0)
            return deleteFirst();
        if(index == size-1)
            return deleteLast();
        Node prev = getnode(index-1);
        int val = prev.next.data;
        prev.next = prev.next.next;
        size--;
        return val;
    }

    public Node getnode(int index){
        Node node = head;
        for (int i=0;i<index;i++){
            node = node.next;
        }
        return node;
    }

    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.data == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    //Questions
    //Q.1 Removing duplicates

    public void removeDuplicates(){
        Node node = head;
        while(node.next != null){
            if(node.data == node.next.data){
                node.next = node.next.next;
                size--;
            }
            else node = node.next;
        }
        tail = node;
        tail.next = null;
    }

//Q.2 merging two linked list

    public static Linkedlist merge(Linkedlist first,Linkedlist second){
        Linkedlist ans = new Linkedlist();
        Node f = first.head;
        Node s = second.head;
        while(f != null && s != null){
            if(f.data < s.data){
                ans.insertLast(f.data);
                f = f.next;
            }
            else{
                ans.insertLast(s.data);
                s = s.next;
            }
        }
        while(f != null) {
            ans.insertLast(f.data);
            f = f.next;
        }

        while(s != null) {
            ans.insertLast(s.data);
            s=s.next;
        }
        return ans;
    }

    //Q.3 Cycle detection and length pf cycle

    public int cyclelength(Node head){
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                int length = 0;
                Node temp = slow;
                do{
                    temp = temp.next;
                    length++;
                }while(temp != fast);
                return length;
            }
        }
        return 0;

    }

    //Q.4 Finding the node at which cycle is present
    //first find the length of cycle and then using 2 pointer method move the second pointer (length of cycle)xtimes

    public int Cyclenode(Node head){
        Node fast = head;
        Node slow = head;
        int length = 0;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                length = cyclelength(slow);
                break;
            }

        }
        if(length == 0)
            return -1;
        //find the start node by shifting s by length of cycle times.
        Node f = head;
        Node s = head;
        while(length > 0){
            s = s.next;
            length--;
        }
        //keep moving the forward and start to get the cycle start node
        while(f != s){
            f = f.next;
            s = s.next;
        }
        return s.data;
    }

    //Q.5 Finding Happy number leetcode
    // A happy number is a number in which the sum of squares of digits at any point of interval of looping becomes 1.
    // e.g: 19 is a happy number as:
    //Explanation:
    //12 + 92 = 82
    //82 + 22 = 68
    //62 + 82 = 100
    //12 + 02 + 02 = 1
    //using cycle detection algo in this as follows:

    public boolean isHappy(int n){
        int slow = n;
        int fast = n;
        do{
            slow = getSquare(slow);
            fast = getSquare(getSquare(fast));
        }while(slow != fast);

        if(slow == 1)
            return true;
        return false;
    }

    public int getSquare(int num){
        int ans = 0;
        while(num > 0){
            int rem = num % 10;
            ans += rem*rem;
            num /= 10;
        }
        return ans;
    }
    // To find the middle node use 2 pointer method
    public Node getmid(Node head){
        Node f = head;
        Node s = head;
        while(f != null && f.next != null){
            f = f.next.next;
            s = s.next;
        }
        return s;
    }
   //----------------------------------------------------------------------------------------
    //Q.6 Merge sort in linked list
    //We already have our merge() but it returns a linked list so modify it to return a node.
    //mergesort includes 3 methods:
    //1.merge()
    //2.mid()
    //sort()

    //Modiified merge() :
    public Node mergeTwoLists(Node list1, Node list2) {
        Node dummy = new Node();
        Node temp = dummy;
        while(list1 != null && list2 != null){
            if(list1.data < list2.data){
                temp.next = list1;
                list1 = list1.next;
                temp = temp.next;
            }
            else{
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next;
            }
        }
        temp.next = (list1 != null)?list1:list2;
        return dummy.next;

    }


    //another method to find mid
    public Node Getmid(Node head){
        Node prev = null;
        while(head != null && head.next != null){
            prev = (prev == null)?head:prev.next;
            head = head.next.next;
        }
        Node mid = prev.next;
        prev.next = null;
        return mid;
    }

    // to create a sort method

    public Node sortList(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node mid = Getmid(head);
        Node left = sortList(head);
        Node right = sortList(mid);

        return mergeTwoLists(left,right);
    }
    //----------------------------------------------------------------------------------------------

    //Q.7 reverse a linked list -1 recursive
    public void reverseRec(Node node){
        if(node == tail){
            head = tail;
            return;
        }
        reverseRec(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    //Q.8 In-place reversal or iterative approach to reverse list

    public Node reverse(Node head){
        if(size < 2)
            return null;
        Node prev = null;
        Node cur = head;
        Node next = cur.next;

        while(cur != null){
            cur.next = prev;
            prev = cur;
            cur = next;
            if(next != null)
            next = next.next;
        }
        head = prev;
        return head;
    }
    //-----------------------------------------------------
    public Node reverseList(Node head) {
        if (head == null) {
            return head;
        }
        Node prev = null;
        Node present = head;
        Node next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }
    //-----------------------------------------------------

    //Q.9 reverse list ii leetcode

    public Node reverseList(Node head,int left,int right){
        if(left == right)
            return head;
        Node cur = head;
        Node prev = null;
        for(int i=0;cur != null && i<left-1;i++){
            prev = cur;
            cur = cur.next;

        }
        Node last = prev;
        Node newEnd = cur;
        Node next = cur.next;
        int i=0;
        while(cur != null && i < right-left+1 ){
            cur.next = prev;
            prev = cur;
            cur = next;
            if(next != null)
                next = next.next;
            i++;

        }
        if(last != null)
        last.next = prev;
        else head = prev; //As it will be the 1st node.
        newEnd.next = cur;

        return head;
    }

    //Q.10 Return whether a list is palindrome or not
    public boolean isPalin(Node head){
        if(head == null || head.next == null)
            return true;
        Node mid = getmid(head);
        Node secondHead =  reverse(mid);
        Node rereversehead = secondHead; //to re reverse the list
          //compare both halves
        while(head != null || secondHead != null){
            if(head.data != secondHead.data){
                break;
            }
            head = head.next;
            secondHead = secondHead.next;
        }
        if(head == null || secondHead == null)
            return true;
        reverse(rereversehead);

        return false;
    }


    //Q.11 Reorder list

    public void reorderList(Node head){
        if(head == null || head.next == null)
            return;
        Node mid = getmid(head);
        Node headsecond = reverse(mid);
        Node headf = head;

        //rearranging
        while(headf != null && headsecond != null){
            Node temp = headf.next;
            headf.next = headsecond;
            headf = temp;
            temp = headsecond.next;
            headsecond.next = headf;
            headsecond = temp;
        }
        if(headf != null)
            headf.next = null;
    }

    //Q.12 reverse nodes in k groups

    public Node reverseinGroups(Node head,int k){
        if(head == null)
            return null;
        Node prev = null;
        Node cur = head;
        Node next = null;
        int count =0;
        //Reverse the first k node of list
        while(count < k && cur != null){
            next = next.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            count++;


        }
        for(int i=0;cur != null && i<k;i++){
            prev = cur;
            cur = cur.next;
        }
            //As the next node is a pointer to the (k+1)th node so recursively call for reverse starting for current and reverse
        // the rest of list.
        if(next != null)
           head.next =  reverseinGroups(next,k);

        return prev;
    }

    //Q.13 reverse node in k groups or less leetcode:HARD

    public Node reverseKGroup(Node head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        Node current = head;
        Node prev = null;

        int length = getLength(head);
        int count = length / k;
        while (count > 0) {
            Node last = prev;
            Node newEnd = current;

            Node next = current.next;
            for (int i = 0; current != null && i < k; i++) {
                current.next = prev;
                prev = current;
                current = next;
                if (next != null) {
                    next = next.next;
                }
            }

            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }

            newEnd.next = current;

            prev = newEnd;
            count--;
        }
        return head;
    }

    public int getLength(Node head) {
        Node node = head;
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    //Q.14 rotate a list leetcode

    public Node rotateListKtimes(Node head,int k){
        if(k <= 0 || head == null || head.next == null)
            return head;

        int length = 1;
        Node last = head;
        while(last != null){
            last = last.next;
            length++;
        }
        last.next = head;
        int rotations = k % length;
        int skip = length - rotations;
        Node tailnext = head;
        for(int i=0;i<skip-1;i++){
            tailnext = tailnext.next;
        }
        head = tailnext.next;
        tailnext.next = null;

        return head;

    }
    public static void main(String args[]){
       /* Linkedlist l = new Linkedlist();
        l.insertLast(1);
        l.insertLast(1);
        l.insertLast(2);
        l.insertLast(3);
        l.insertLast(4);
        l.insertLast(4);
        l.display();
        l.removeDuplicates();
        l.display();*/
        Linkedlist f = new Linkedlist();
        Linkedlist s = new Linkedlist();
        f.insertLast(1);
        f.insertLast(2);
        f.insertLast(4);
        f.insertLast(7);
        s.insertLast(0);
        s.insertLast(3);
        s.insertLast(5);
        s.insertLast(14);
        s.insertLast(54);
        s.getnode(4).next = s.getnode(3);

        //f.display();
       // s.display();
       // int l = s.cyclelength(s.head);
       int a = s.Cyclenode(s.head);
        System.out.println(a);

        //Linkedlist ans = merge(f,s);
        //ans.display();




    }


    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
        public Node(int data,Node next){
           this.data = data;
           this.next = next;
        }
        public Node(){

        }
    }
}
