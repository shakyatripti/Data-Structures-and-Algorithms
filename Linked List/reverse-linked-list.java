//Problem: https://leetcode.com/problems/reverse-linked-list/description/




import java.io.*;
import java.util.*;

class ListNode {
    ListNode next;
    int val;
    ListNode(int data, ListNode n) {
        val = data;
        next = n;
    }
}

class ReverseLinkedList {
    public ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while(curr!=null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
    
    public void display(ListNode head) {
        while(head!=null) {
            System.out.print(head.val + " ");
            head=head.next;
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        ReverseLinkedList ll = new ReverseLinkedList();
        ListNode head = new ListNode(1, null);
        head.next = new ListNode(2, null);
        head.next.next = new ListNode(3, null);
        head.next.next.next = new ListNode(4, null);
        ListNode ans = ll.reverse(head);
        ll.display(ans);
        
        ListNode head1 = new ListNode(8, null);
        head1.next = new ListNode(9, null);
        ListNode ans1 = ll.reverse(head1);
        ll.display(ans1);
    }
}