//Problem: https://leetcode.com/problems/odd-even-linked-list/description/




//Brute force solution: Using two loops
import java.io.*;
import java.util.*;

class ListNode {
    ListNode next;
    int val;
    ListNode(int data) {
        val = data;
    }
}

class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null) {
            return head;
        }
        ListNode head1=head, head2=head.next;
        ListNode list = new ListNode(-1);
        ListNode ans1 = list;
        while(head1!=null) {
            list.next = new ListNode(head1.val);
            list = list.next;
            if(head1.next!=null) {
                head1 = head1.next.next;
            } else {
                head1 = null;
            }
        }
        while(head2!=null) {
            list.next = new ListNode(head2.val);
            list = list.next;
            if(head2.next!=null) {
                head2 = head2.next.next;
            } else {
                head2 = null;
            }
        }
        return ans1.next;
    }
    
    public void display(ListNode ans) {
        while(ans!=null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
        System.out.println();
    }
}


class Main {
    public static void main(String[] args) {
        OddEvenLinkedList list = new OddEvenLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode ans = list.oddEvenList(head);
        list.display(ans);
        
        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(5);
        head1.next.next.next.next = new ListNode(6);
        head1.next.next.next.next.next = new ListNode(4);
        head1.next.next.next.next.next.next = new ListNode(7);
        ListNode ans1 = list.oddEvenList(head1);
        list.display(ans1);
        
        
    }
}