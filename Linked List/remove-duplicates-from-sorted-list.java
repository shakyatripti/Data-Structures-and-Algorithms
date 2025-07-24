//Problem: https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/



import java.io.*;
import java.util.*;

class ListNode {
    ListNode next;
    int val;
    ListNode(int data) {
        val = data;
    }
    ListNode(int data, ListNode n) {
        val = data;
        next = n;
    }
}

class RemoveDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode prev = new ListNode(-1, head), curr = head, head1 = prev;
        while(curr!=null) {
            ListNode nextNode = curr.next;
            if(nextNode!=null && curr.val==nextNode.val) {
               prev.next = nextNode;
            } else {
               prev = curr;
            }
            curr = nextNode;
        }
        return head1.next;
    }
    
    public void display(ListNode head) {
        if(head==null) {
            System.out.print("empty");
        }
        while(head!=null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        RemoveDuplicates ll = new RemoveDuplicates();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        ListNode ans = ll.deleteDuplicates(head);
        ll.display(ans);
        
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(5);
        ListNode ans1 = ll.deleteDuplicates(head1);
        ll.display(ans1);
        
        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(4);
        head2.next.next.next = new ListNode(4);
        ListNode ans2 = ll.deleteDuplicates(head2);
        ll.display(ans2);
    }
}