package com.Sundeep;

public class AddtoNumbersUsingLinkedList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode l3 = head;
        int carry=0;
        while(l1 != null || l2 != null){
            int val1 = (l1 != null)?l1.val:0;
            int val2 = (l2 != null)?l2.val:0;
            int sum = val1+val2+carry;
            int finalsum = sum%10;
            carry = sum/10;
            ListNode newnode = new ListNode(finalsum);
            l3.next = newnode;
            if(l1 != null) l1=l1.next;
            if(l2 != null) l2=l2.next;
            l3 = l3.next;
        }
        if(carry > 0){
            ListNode carrynode = new ListNode(carry);
            l3.next = carrynode;
        }
        return head.next;
    }
}
