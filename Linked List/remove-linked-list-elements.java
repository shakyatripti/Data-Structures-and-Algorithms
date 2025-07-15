//Problem: https://leetcode.com/problems/remove-linked-list-elements/description/




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
    ListNode() {}
}

class RemoveElements {
    public ListNode remove(ListNode head, int val) {
        if(head==null) {
            return head;
        }
        ListNode prev=new ListNode(-1,head), curr=head, head1=prev;
        while(curr!=null) {
            ListNode nextNode = curr.next;
            if(curr.val==val) {
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
        RemoveElements ll = new RemoveElements();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(6);
        ListNode ans  = ll.remove(head, 6);
        ll.display(ans);
        
        ListNode head1 = new ListNode(7);
        head1.next = new ListNode(7);
        head1.next.next = new ListNode(7);
        head1.next.next.next = new ListNode(7);
        ListNode ans1 = ll.remove(head1, 7);
        ll.display(ans1);
        
        ListNode head2 = new ListNode();
        ListNode ans2 = ll.remove(head2, 7);
        ll.display(ans2);
    }
}